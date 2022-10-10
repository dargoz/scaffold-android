package com.dargoz.scaffold.arch.features.login.presentation.mappers;

import com.dargoz.scaffold.arch.features.login.domain.entities.AuthEntity;
import com.dargoz.scaffold.arch.features.login.presentation.models.LoginModel;

public class AuthPresenterMappers {

    public static LoginModel mapToModel(AuthEntity authEntity) {
        return new LoginModel(authEntity.getAccessToken(), authEntity.getRole());
    }

}
