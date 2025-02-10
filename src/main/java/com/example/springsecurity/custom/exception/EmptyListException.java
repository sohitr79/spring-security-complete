package com.example.springsecurity.custom.exception;

import org.springframework.stereotype.Component;

@Component
public class EmptyListException extends RuntimeException {
    private String errorCode;

    public EmptyListException(String errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
    }

    public EmptyListException() {

    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

}
