package com.example.springsecurity.model;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ErrorResponse {
    private String message;
    private String timestamp;
    private String status;

    public ErrorResponse(String message, String status) {
        this.message = message;
        this.timestamp = LocalDateTime.now().toString();
        this.status = status;
    }
}
