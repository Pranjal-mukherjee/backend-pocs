package com.zemoso.assesment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductNotFoundH {
    @ExceptionHandler
    public ResponseEntity<ProductNotFoundBody> handleException(ProductNotFound productNotFound){
        ProductNotFoundBody productNotFoundBody = new ProductNotFoundBody(HttpStatus.NOT_FOUND.value(), productNotFound.getMessage(),System.currentTimeMillis());
        return new ResponseEntity<>(productNotFoundBody,HttpStatus.NOT_FOUND);
    }
}
