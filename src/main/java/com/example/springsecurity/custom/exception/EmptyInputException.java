package com.example.springsecurity.custom.exception;

public class EmptyInputException extends RuntimeException {
    private String errorCode;

    public EmptyInputException(String errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
    }

    public EmptyInputException() {
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }


}
