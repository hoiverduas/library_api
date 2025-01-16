package com.javaDv.library_api.exception;

import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandle {


    @ExceptionHandler(BookNotFound.class)
    public ResponseEntity<String> handleBookNotFound(BookNotFound e){

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());

    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<String> handleValidationException(ValidationException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ex.getMessage());
    }


}
