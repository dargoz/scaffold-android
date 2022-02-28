package com.dargoz.scaffold.arch.features.feedback.data.datasources.local;

import android.util.Log;

import com.dargoz.scaffold.arch.features.feedback.data.datasources.local.models.Issue;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class LocalDataSource {
    private final RealmConfiguration realmConfiguration;

    @Inject
    public LocalDataSource(RealmConfiguration realmConfiguration) {
        this.realmConfiguration = realmConfiguration;
    }

    public Flowable<List<Issue>> getIssue(int id) {
        return new RealmHelper<List<Issue>>().getInstanceAsync(realmConfiguration, (realm, s) -> {
            Log.d("DRG","success call realm : " + realm.getPath());
            RealmResults<Issue> realmResults = realm.where(Issue.class).findAll();
            s.onNext(realm.copyFromRealm(realmResults));
            realm.close();
        });
    }

    public Flowable<Issue> insertIssue(Issue issue) {
        return new RealmHelper<Issue>().getInstanceAsync(realmConfiguration, (realm, s) -> {
            Log.d("DRG","insertIssue :: success call realm : " + realm.getPath());
            try {
                realm.executeTransactionAsync(transaction -> {
                    try {
                        issue.setId(issue.hashCode());
                        transaction.insert(issue);
                        s.onNext(issue);
                    } catch (Exception e) {
                        s.onError(e);
                    }
                }, realm::close);
            } catch (Exception e) {
                s.onError(e);
            }
        });
    }
}
