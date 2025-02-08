package com.demo_rest.demo_rest_crud.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {
    public StudentRestExceptionHandler() {
        System.out.println("In Controller Advice Constructor: ");
    }
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException (StudentNotFoundException exc) {
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(String.valueOf(HttpStatus.NOT_FOUND.value()));
        error.setMessage(exc.getMessage());
        error.setTimeStamp((long)System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(String.valueOf(HttpStatus.BAD_REQUEST.value()));
        error.setMessage(exc.getMessage());
        error.setTimeStamp((long)System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

    }
}
