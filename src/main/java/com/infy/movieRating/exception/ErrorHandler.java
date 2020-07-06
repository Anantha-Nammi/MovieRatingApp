package com.infy.movieRating.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

public class ErrorHandler {

    @ExceptionHandler(MovieException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> handleAppException(MovieException appEx, WebRequest request) {
        MovieErrorData appError = new MovieErrorData( appEx.getMessage(), request.getDescription(false));
        return new ResponseEntity(appError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> errorHandler(Exception ex, WebRequest request) {
        MovieErrorData appError = new MovieErrorData( ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(appError, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
