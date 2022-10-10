package com.dargoz.scaffold.arch.features.login.domain.repositories;

import com.dargoz.core.models.Result;
import com.dargoz.scaffold.arch.features.login.domain.entities.AuthEntity;

import io.reactivex.Single;

public interface AuthRepository {

    Single<Result<AuthEntity>> requestAuth(String username, String password);

}
