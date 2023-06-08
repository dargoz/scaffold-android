package com.dargoz.scaffold.arch.features.login.di;

import com.dargoz.scaffold.arch.features.login.data.repositories.AuthRepositoryImpl;
import com.dargoz.scaffold.arch.features.login.domain.repositories.AuthRepository;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module(includes = {AuthNetworkModule.class})
@InstallIn(SingletonComponent.class)
public abstract class AuthDataModule {

    @Binds
    public abstract AuthRepository provideAuthRepository(AuthRepositoryImpl authRepository);
}
