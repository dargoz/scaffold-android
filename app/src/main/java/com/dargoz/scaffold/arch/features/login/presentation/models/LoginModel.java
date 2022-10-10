package com.dargoz.scaffold.arch.features.login.presentation.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginModel {

    private String token;
    private String role;

}
