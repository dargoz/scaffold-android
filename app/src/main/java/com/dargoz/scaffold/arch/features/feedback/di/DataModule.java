package com.dargoz.scaffold.arch.features.feedback.di;

import com.dargoz.scaffold.arch.features.feedback.data.repositories.RepositoryImpl;
import com.dargoz.scaffold.arch.features.feedback.domain.repositories.Repository;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module(includes = {NetworkModule.class, LocalModule.class})
@InstallIn(SingletonComponent.class)
public abstract class DataModule {

    @Binds
    public abstract Repository provideRepository(RepositoryImpl repository);

}
