package com.dargoz.scaffold.arch.core.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result<T> {

    private int statusCode;
    private String statusMessage;
    private T data;

}
