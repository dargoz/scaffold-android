package com.dargoz.scaffold.arch.features.feedback.data.datasources.local;

import android.os.Looper;

import androidx.annotation.NonNull;

import com.dargoz.scaffold.arch.BuildConfig;

import org.reactivestreams.Subscriber;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class RealmHelper<T> {

    public interface Callback<R> {
        void onSuccess(Realm realm, Subscriber<? super R> s);
    }

    public Flowable<T> getInstanceAsync(RealmConfiguration configuration, Callback<T> callback) {
        return new Flowable<T>() {
            @Override
            protected void subscribeActual(Subscriber<? super T> s) {
                try {
                    Realm.getInstanceAsync(configuration, new Realm.Callback() {
                        @Override
                        public void onSuccess(@NonNull Realm realm) {
                            if(!realm.isClosed()) {
                                callback.onSuccess(realm, s);
                            } else {
                                s.onError(new Exception("Realm is Closed"));
                            }
                        }

                        @Override
                        public void onError(@NonNull Throwable exception) {
                            if(BuildConfig.DEBUG) {
                                exception.printStackTrace();
                            }
                            s.onError(exception);
                        }
                    });
                } catch (Exception e) {
                    if(BuildConfig.DEBUG) {
                        e.printStackTrace();
                    }
                    s.onError(e);
                }
            }
        };
    }

}
