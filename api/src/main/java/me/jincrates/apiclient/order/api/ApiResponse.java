package me.jincrates.apiclient.order.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public record ApiResponse<T>(
    int status,
    String message,
    T data
) {

    private ApiResponse(HttpStatus httpStatus, String message, T data) {
        this(httpStatus.value(), message, data);
    }

    public static <T> ApiResponse<T> of(HttpStatus httpStatus, String message, T data) {
        return new ApiResponse<>(httpStatus, message, data);
    }

    public static ResponseEntity<ApiResponse<?>> error(HttpStatus httpStatus, String message) {
        return ResponseEntity.status(httpStatus).body(of(httpStatus, message, null));
    }
}
