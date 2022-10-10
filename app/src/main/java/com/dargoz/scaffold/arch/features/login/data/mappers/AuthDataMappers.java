package com.dargoz.scaffold.arch.features.login.data.mappers;

import com.dargoz.scaffold.arch.features.login.data.datasources.remote.responses.AuthResponse;
import com.dargoz.scaffold.arch.features.login.domain.entities.AuthEntity;

public class AuthDataMappers {

    public static AuthEntity mapToEntity(AuthResponse authResponse) {
        return new AuthEntity(authResponse.getToken(), authResponse.getRole());
    }
}
