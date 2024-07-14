package com.practice.myapplication.exceptions;

import com.practice.myapplication.models.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value ={Exception.class} )
    public ResponseEntity<ExceptionResponse> HandleAnyException(Exception ex, WebRequest webRequest)
    {
        String exceptionMessage = ex.getLocalizedMessage();

        if(exceptionMessage==null)
            exceptionMessage = ex.toString();

        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),exceptionMessage);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {NullPointerException.class, TaskServiceException.class})
    public ResponseEntity<ExceptionResponse> HandleSpecificException(Exception ex, WebRequest webRequest)
    {
        String exceptionMessage = ex.getLocalizedMessage();

        if(exceptionMessage ==null)
            exceptionMessage = ex.toString();

        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Specific - " +exceptionMessage);
        return new ResponseEntity<>(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }

//    @ExceptionHandler(value = TaskServiceException.class)
//    public ResponseEntity<ExceptionResponse> HandleTaskServiceException(TaskServiceException ex, WebRequest webRequest)
//    {
//        String taskServiceExceptionMessage = ex.getLocalizedMessage();
//
//        if(taskServiceExceptionMessage ==null)
//            taskServiceExceptionMessage = ex.toString();
//
//        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), taskServiceExceptionMessage);
//        return new ResponseEntity<>(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
//    }
}
