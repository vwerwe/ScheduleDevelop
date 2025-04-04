package com.example.scheduledevelop.exception;

public class DuplicateSignUpException extends RuntimeException{

    private String message;

    public DuplicateSignUpException(String message) {
        super(message);
    }

}
