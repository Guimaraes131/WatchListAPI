package io.github.Guimaraes131.watchlistapi.controller.dto;

import org.springframework.http.HttpStatus;

import java.util.List;

public record ErrorResponse(int status, String message, List<FieldError> errors) {

    public static ErrorResponse badRequestResponse(String message) {
        return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), message, List.of());
    }

    public static ErrorResponse conflictResponse(String message) {
        return new ErrorResponse(HttpStatus.CONFLICT.value(), message, List.of());
    }

    public static ErrorResponse internalServerErrorResponse(String message) {
        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), message, List.of());
    }
}
