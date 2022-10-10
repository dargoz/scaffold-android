package com.dargoz.scaffold.arch.features.login.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthEntity {

    private String accessToken;
    private String role;

}
