package com.dargoz.scaffold.arch.features.feedback.di;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import io.realm.RealmConfiguration;

@Module
@InstallIn(ActivityComponent.class)
public class LocalModule {

    @Provides
    public static RealmConfiguration provideRealmConfiguration() {
        return new RealmConfiguration.Builder()
                .name("scaffold-db")
                .schemaVersion(1)
                .build();
    }

}
