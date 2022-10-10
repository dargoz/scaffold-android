package com.dargoz.scaffold.arch.features.login.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthFormEntity {
    private String username;
    private String password;
}
