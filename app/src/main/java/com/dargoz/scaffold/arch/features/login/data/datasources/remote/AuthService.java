package com.dargoz.scaffold.arch.features.login.data.datasources.remote;

import com.dargoz.core.models.ApiResponse;
import com.dargoz.scaffold.arch.features.login.data.datasources.remote.requests.AuthRequest;
import com.dargoz.scaffold.arch.features.login.data.datasources.remote.responses.AuthResponse;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthService {

    @POST("MB/BackOffice/v1/login/verify")
    Single<ApiResponse<AuthResponse>> requestAuth(@Body AuthRequest authRequest);

}
