package com.dargoz.scaffold.arch.features.feedback.di;

import android.content.Context;

import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.rxjava2.RxPreferenceDataStoreBuilder;
import androidx.datastore.rxjava2.RxDataStore;

import com.dargoz.scaffold.arch.features.feedback.data.datasources.local.migration.Migration;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import io.realm.RealmConfiguration;

@Module
@InstallIn(SingletonComponent.class)
public class LocalModule {

    @Provides
    public static RealmConfiguration provideRealmConfiguration() {
        return new RealmConfiguration.Builder()
                .name("scaffold-db")
                .schemaVersion(1)
                .migration(new Migration())
                .build();
    }

    @Provides
    public static RxDataStore<Preferences> provideDataStore(@ApplicationContext Context context) {
        return new RxPreferenceDataStoreBuilder(context, "scaffold-setting").build();
    }

}
