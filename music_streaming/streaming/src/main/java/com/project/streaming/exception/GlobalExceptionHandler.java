package com.project.streaming.exception;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    public ResponseEntity<ApiError> handleNotFound(ResourceNotFound ex, HttpServletRequest request) {
        ApiError error = new ApiError(ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(404).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleGeneric(Exception ex, HttpServletRequest request) {
        ApiError error = new ApiError("Internal server error: " + ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(500).body(error);
    }
}
