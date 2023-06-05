package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(value = HttpStatus.NOT_FOUND) // This allows us to change the status code when the exception is raised. We comment this because now the ApiExceptionHandler is going to handle this exception with a bunch of data, including the http status.
public class NotFoundException  extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
