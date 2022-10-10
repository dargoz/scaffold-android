package com.dargoz.scaffold.arch.features.login.data.datasources.remote.responses;

import lombok.Data;

@Data
public class AuthResponse {
    private String token;
    private String role;
}
