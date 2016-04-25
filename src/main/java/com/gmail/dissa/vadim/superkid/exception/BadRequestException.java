package com.gmail.dissa.vadim.superkid.exception;

// Own exception thrown when data not found in database
public class BadRequestException extends RuntimeException{
    public BadRequestException(String message) {
        super(message);
    }
    public BadRequestException(String message, Throwable cause) {
        super(message);
    }
}
