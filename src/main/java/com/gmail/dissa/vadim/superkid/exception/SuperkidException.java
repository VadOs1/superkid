package com.gmail.dissa.vadim.superkid.exception;

public class SuperkidException extends RuntimeException {
    public SuperkidException(RuntimeException exception) {
        super(exception);
    }

    public SuperkidException(String message) {
        super(message);
    }
}
