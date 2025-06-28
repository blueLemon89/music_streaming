package com.project.streaming.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ApiError {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd HH:mm:ss")
    private LocalDateTime errorTime;
    private String message;
    private String path;

    public ApiError(String message, String path) {
        this.errorTime = LocalDateTime.now();
        this.message = message;
        this.path = path;
    }
}
