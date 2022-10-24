package com.ibm.restaurant.domain.exception;

public class BusinessException extends RuntimeException{

    private String message;
    private String code;

    public BusinessException(String message, String code) {
        this.message = message;
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }
}
