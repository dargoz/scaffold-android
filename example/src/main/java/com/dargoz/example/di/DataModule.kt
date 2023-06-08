package com.dargoz.example.di

import com.dargoz.example.data.sources.local.OccupationRealmModule
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.realm.RealmConfiguration

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @ExampleRealm
    fun provideRealmConfiguration(): RealmConfiguration {
        return RealmConfiguration.Builder()
            .name("example-db")
            .modules(OccupationRealmModule())
            .schemaVersion(1)
            .build()
    }
}