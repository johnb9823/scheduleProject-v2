package com.example.schedulev2.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> {

    private int code;
    private String message;
    private T data;

    public static <T> CommonResponse<T> success(T data) {
        return new CommonResponse<>(
                StatusCode.SUCCESS.getCode(),
                StatusCode.SUCCESS.getMessage(),
                data
        );
    }

    public static <T> CommonResponse<T> of(StatusCode statusCode, T data) {
        return new CommonResponse<>(
                statusCode.getCode(),
                statusCode.getMessage(),
                data
        );
    }

    public static CommonResponse<?> of(StatusCode statusCode) {
        return new CommonResponse<>(
                statusCode.getCode(),
                statusCode.getMessage(),
                null
        );
    }
}
