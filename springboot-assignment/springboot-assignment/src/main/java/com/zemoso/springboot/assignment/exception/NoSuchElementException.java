package com.zemoso.springboot.assignment.exception;

public class NoSuchElementException extends RuntimeException{
    public NoSuchElementException(String message) {
        super(message);
    }

    public NoSuchElementException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchElementException(Throwable cause) {
        super(cause);
    }
}
