package com.in28minutes.springboot.microservice.example.forex.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler
{

    @ExceptionHandler( FSDataNotFoundException.class )
    @ResponseStatus( HttpStatus.NOT_FOUND )
    public final Exception handleNotFoundException( FSDataNotFoundException ex,
                                                               WebRequest request )
    {
        return ex;
    }

    @ExceptionHandler( Exception.class )
    @ResponseStatus( HttpStatus.INTERNAL_SERVER_ERROR )
    public final Exception handleServiceUnavailableExceptions( Exception ex,
                                                               WebRequest request )
    {
        return ex;
    }

}
