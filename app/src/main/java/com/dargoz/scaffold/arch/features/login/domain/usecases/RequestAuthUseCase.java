package com.dargoz.scaffold.arch.features.login.domain.usecases;

import android.util.Log;

import com.dargoz.core.models.Result;
import com.dargoz.core.usecase.SingleRxUseCase;
import com.dargoz.scaffold.arch.features.login.domain.entities.AuthEntity;
import com.dargoz.scaffold.arch.features.login.domain.entities.AuthFormEntity;
import com.dargoz.scaffold.arch.features.login.domain.repositories.AuthRepository;

import javax.inject.Inject;

import io.reactivex.Single;

public class RequestAuthUseCase extends SingleRxUseCase<Result<AuthEntity>, AuthFormEntity> {
    private final AuthRepository repository;

    @Inject
    public RequestAuthUseCase(AuthRepository repository) {
        this.repository = repository;
    }


    @Override
    protected Single<Result<AuthEntity>> buildUseCase(AuthFormEntity authFormEntity) {
        Log.d("DRG","execute use case");
        return repository.requestAuth(authFormEntity.getUsername(), authFormEntity.getPassword());
    }
}
