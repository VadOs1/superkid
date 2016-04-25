package com.gmail.dissa.vadim.superkid.exception;

// Own exception thrown when empty object in checkout
public class CheckoutException extends RuntimeException {
    public CheckoutException(String message) {
        super(message);
    }
    public CheckoutException(String message, Throwable cause) {
        super(message);
    }
}
