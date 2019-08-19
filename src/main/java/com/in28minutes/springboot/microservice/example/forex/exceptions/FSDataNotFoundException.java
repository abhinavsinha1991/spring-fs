package com.in28minutes.springboot.microservice.example.forex.exceptions;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties( { "localizedMessage", "message", "suppressed", "stackTrace", "cause" } )
public class FSDataNotFoundException extends Exception
{

    private static final long serialVersionUID = 7718828512143293558L;

    private int status = 404;

    private List<FSError> errors = new ArrayList<>();

    public FSDataNotFoundException( String message, Throwable cause )
    {
        super( message, cause );
        this.errors.add( FSError.builder()
                .internalMessage( message )
                .developerMessage( message )
                .userMessage( "Requested data not found" )
                .build() );
    }

    public FSDataNotFoundException( String message )
    {
        super( message );
        this.errors.add( FSError.builder()
                .internalMessage( message )
                .developerMessage( message )
                .userMessage( "Requested data not found" )
                .build() );
    }

    public FSDataNotFoundException( Throwable cause )
    {
        super( cause );

        this.errors.add( FSError.builder()
                .internalMessage( cause.getMessage() )
                .developerMessage( cause.getMessage() )
                .userMessage( "Requested data not found" )
                .build() );
    }

    /**
     * @return The status.
     */
    public int getStatus()
    {
        return status;
    }

    /**
     * @param status The status to set.
     */
    public void setStatus( final int status )
    {
        this.status = status;
    }

    /**
     * @return The errors.
     */
    public List<FSError> getErrors()
    {
        return errors;
    }

    /**
     * @param errors The errors to set.
     */
    public void setErrors(
            final List<FSError> errors )
    {
        this.errors = errors;
    }
}