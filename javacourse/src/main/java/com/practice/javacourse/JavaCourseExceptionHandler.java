package com.practice.javacourse;

import com.practice.javacourse.exception.ContactNotFoundException;
import com.practice.javacourse.exception.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class JavaCourseExceptionHandler extends ResponseEntityExceptionHandler {

        @ExceptionHandler(ContactNotFoundException.class)
        public ResponseEntity<ErrorResponse> handleContactNotFoundException(ContactNotFoundException ex){
            ErrorResponse errorResponse = new ErrorResponse(Arrays.asList(ex.getLocalizedMessage()));
            return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
        }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

             List<String> errors = new ArrayList<>();

             //ObjectError represents a validation error at the object level. It means: The whole object is invalid.
//            for (ObjectError error : ex.getBindingResult().getAllErrors()){
//                errors.add(error.getDefaultMessage());
//            }

        //FieldError represents a validation error for a specific field.It means:This particular field is invalid.
        //FieldError extends ObjectError , Every FieldError IS an ObjectError, But not every ObjectError is a FieldError
        for (FieldError error : ex.getBindingResult().getFieldErrors()){
            errors.add("{\n" +
                    "   \"field\": \"" + error.getField() + "\",\n" +
                    "   \"message\": \"" + error.getDefaultMessage() + "\"\n" +
                    "}");
        }
            return new ResponseEntity<>(new ErrorResponse(errors),HttpStatus.BAD_REQUEST);
    }
}
