package com.example.doctorai.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(GigaChatNewsException.class)
    public String handleException(GigaChatNewsException e) {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @ExceptionHandler(CreateNewsException.class)
    public String handleException(CreateNewsException e) {
        return e.getMessage();
    }


    @ResponseStatus(HttpStatus.GATEWAY_TIMEOUT)
    @ExceptionHandler(TokenExecption.class)
    public String handleException(TokenExecption e) {return e.getMessage();}
}