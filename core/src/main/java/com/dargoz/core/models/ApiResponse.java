package com.dargoz.core.models;

import lombok.Data;

@Data
public class ApiResponse<T> {
    ErrorSchema errorSchema;
    T outputSchema;
}
