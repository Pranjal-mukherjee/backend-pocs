package com.zemoso.assesment.exception;

public class ProductNotFound extends RuntimeException {
    public ProductNotFound(String message) {
        super(message);
    }

    public ProductNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductNotFound(Throwable cause) {
        super(cause);
    }
}
