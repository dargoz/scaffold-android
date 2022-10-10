package com.dargoz.scaffold.arch.features.login.data.repositories;

import android.util.Log;

import com.dargoz.core.errors.ServerApiFailure;
import com.dargoz.core.models.Result;
import com.dargoz.core.models.UiState;
import com.dargoz.scaffold.arch.features.login.data.datasources.remote.AuthRemoteDataSource;

import com.dargoz.scaffold.arch.features.login.data.mappers.AuthDataMappers;
import com.dargoz.scaffold.arch.features.login.domain.entities.AuthEntity;
import com.dargoz.scaffold.arch.features.login.domain.repositories.AuthRepository;

import javax.inject.Inject;

import io.reactivex.Single;

public class AuthRepositoryImpl implements AuthRepository {
    private final AuthRemoteDataSource authRemoteDataSource;

    @Inject
    public AuthRepositoryImpl(AuthRemoteDataSource authRemoteDataSource) {
        this.authRemoteDataSource = authRemoteDataSource;
    }

    @Override
    public Single<Result<AuthEntity>> requestAuth(String username, String password) {
        Log.d("DRG","request repository..");
        return authRemoteDataSource.requestAuth(username, password).map(response -> {
            Log.d("DRG","response repository..");
            if (response.getErrorSchema().getErrorCode().equals("MB-00-000")) {
                        return new Result<>(
                                UiState.success,
                                "",
                                AuthDataMappers.mapToEntity(response.getOutputSchema()));
                    } else {
                        throw new ServerApiFailure();
                    }
                }
        );
    }
}
