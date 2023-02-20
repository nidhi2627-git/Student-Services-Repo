package com.example.studentservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = RuntimeException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public errorMessage resourceNotFoundException(RuntimeException ex){
        return new errorMessage(HttpStatus.NOT_FOUND.value(), new Date(), ex.getMessage(), "Resource Not Found");
    }

//    @ExceptionHandler(value = RuntimeException.class)
//    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
//    public errorMessage invalidRequestException(RuntimeException ex){
//        return new errorMessage(HttpStatus.BAD_REQUEST.value(), new Date(), ex.getMessage(), "Request is invalid");
//    }

}
