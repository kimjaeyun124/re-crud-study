package com.example.crudresutdy.global.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    private final int httpStatus;
    private final String message;
    private final ResponseKind kind;
    private final T data;

    private ApiResponse(HttpStatus status, String message, ResponseKind kind, T data) {
        this.httpStatus = status.value();
        this.message = message;
        this.kind = kind;
        this.data = data;
    }

    public static <T> ApiResponse<T> ok(HttpStatus status, String message, ResponseKind kind) {
        return new ApiResponse<>(status, message, kind, null);
    }

    public static <T> ApiResponse<T> ok(HttpStatus status, String message, ResponseKind kind, T data) {
        return new ApiResponse<>(status, message, kind, data);
    }

    public static <T> ApiResponse<T> fail(HttpStatus status, String message, ResponseKind kind) {
        return new ApiResponse<>(status, message, kind, null);
    }
}
