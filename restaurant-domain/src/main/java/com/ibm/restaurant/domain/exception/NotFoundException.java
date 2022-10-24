package com.ibm.restaurant.domain.exception;

public class NotFoundException extends RuntimeException{

    private String message;

    public NotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
