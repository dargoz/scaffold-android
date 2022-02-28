package com.dargoz.scaffold.arch.features.register.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserEntity {

    private String name;
    private String avatarUrl;
}
