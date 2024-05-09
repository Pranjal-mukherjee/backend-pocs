package com.zemoso.programming.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class TodoNotFoundHandler {
    @ExceptionHandler
    public ResponseEntity<TodoNotFoundBody> handleException(TodoNotFound todoNotFound){
        TodoNotFoundBody todoNotFoundBody = new TodoNotFoundBody(HttpStatus.NOT_FOUND.value(),
                todoNotFound.getMessage(),System.currentTimeMillis());
        return new ResponseEntity<>(todoNotFoundBody, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public  ResponseEntity<Map<String,String>> handleValidation(MethodArgumentNotValidException methodArgumentNotValidException){
        Map<String,String> resp = new HashMap<>();
        methodArgumentNotValidException.getBindingResult().getAllErrors().forEach((error) ->{
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            resp.put(fieldName,message);
        });
        return new ResponseEntity<Map<String,String>>(resp,HttpStatus.BAD_REQUEST);
    }
}
