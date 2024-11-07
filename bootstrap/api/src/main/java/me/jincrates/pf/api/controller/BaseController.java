package me.jincrates.pf.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class BaseController {

    protected <T> ResponseEntity<ApiResponse<T>> ok(
        String message,
        T data
    ) {
        return getResponseEntity(
            HttpStatus.OK,
            message,
            data
        );
    }

    protected <T> ResponseEntity<ApiResponse<T>> create(
        String message,
        T data
    ) {
        return getResponseEntity(
            HttpStatus.CREATED,
            message,
            data
        );
    }

    protected <T> ResponseEntity<ApiResponse<T>> badRequest(String message) {
        return getResponseEntity(
            HttpStatus.BAD_REQUEST,
            message,
            null
        );
    }

    protected <T> ResponseEntity<ApiResponse<T>> unauthorized(String message) {
        return getResponseEntity(
            HttpStatus.UNAUTHORIZED,
            message,
            null
        );
    }

    private <T> ResponseEntity<ApiResponse<T>> getResponseEntity(
        HttpStatus httpStatus,
        String message,
        T data
    ) {
        return ResponseEntity.status(httpStatus)
            .body(ApiResponse.of(
                httpStatus,
                message,
                data
            ));
    }
}
