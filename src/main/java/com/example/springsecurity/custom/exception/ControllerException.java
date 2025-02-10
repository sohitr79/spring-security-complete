package com.example.springsecurity.custom.exception;

import org.springframework.stereotype.Component;

@Component
public class ControllerException extends RuntimeException {

    private String errorCode;

    public ControllerException(String errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
    }

    public ControllerException(){

    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

}
