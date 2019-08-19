package com.in28minutes.springboot.microservice.example.forex.exceptions;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author Abhinav Sinha
 */

@Data
@Builder
@AllArgsConstructor
public class FSValidationError implements Serializable
{

    private String element;
    private String error;

    /**
     * @return The element.
     */
    public String getElement()
    {
        return element;
    }

    /**
     * @param element The element to set.
     */
    public void setElement( final String element )
    {
        this.element = element;
    }

    /**
     * @return The error.
     */
    public String getError()
    {
        return error;
    }

    /**
     * @param error The error to set.
     */
    public void setError( final String error )
    {
        this.error = error;
    }
}
