package com.example.springsecurity.custom.exception;

import org.springframework.stereotype.Component;

@Component
public class BusinessException extends RuntimeException {

    private String errorCode;

    public BusinessException(String errorCode, String errorMessage) {
        super(errorMessage); // Will set this to RuntimeException constructor and we can call e.getMessage();
        this.errorCode = errorCode;
    }

    public BusinessException(){

    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

}
