package com.practice.javacourse;

import com.practice.javacourse.exception.ContactNotFoundException;
import com.practice.javacourse.exception.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class JavaCourseExceptionHandler {

        @ExceptionHandler
        public ResponseEntity<ErrorResponse> handleContactNotFoundException(ContactNotFoundException ex){
            ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());
            return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
        }
}
