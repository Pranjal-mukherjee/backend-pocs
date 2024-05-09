package com.zemoso.programming.exception;

public class TodoNotFound extends RuntimeException{
    public TodoNotFound(String message) {
        super(message);
    }

    public TodoNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public TodoNotFound(Throwable cause) {
        super(cause);
    }
}
