package com.dargoz.scaffold.arch.features.login.data.datasources.remote;

import com.dargoz.core.models.ApiResponse;
import com.dargoz.scaffold.arch.features.login.data.datasources.remote.requests.AuthRequest;
import com.dargoz.scaffold.arch.features.login.data.datasources.remote.responses.AuthResponse;

import javax.inject.Inject;

import io.reactivex.Single;

public class AuthRemoteDataSource {
    private final AuthService authService;

    @Inject
    public AuthRemoteDataSource(AuthService authService) {
        this.authService = authService;
    }

    public Single<ApiResponse<AuthResponse>> requestAuth(String username, String password) {
        return authService.requestAuth(new AuthRequest(username, password));
    }

}
