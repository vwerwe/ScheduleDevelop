package com.example.scheduledevelop.exception;

public class NotLoginException extends RuntimeException{

    private String message;

    public NotLoginException(String message) {
        super(message);
    }

}
