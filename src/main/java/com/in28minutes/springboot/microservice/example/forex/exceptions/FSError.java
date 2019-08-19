package com.in28minutes.springboot.microservice.example.forex.exceptions;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author Abhinav Sinha
 */

@Data
@Builder
@AllArgsConstructor
public class FSError implements Serializable
{

    private String developerMessage;
    private String userMessage;
    private String internalMessage;
    private List<FSValidationError> validationErrors;

    /**
     * @return The developerMessage.
     */
    public String getDeveloperMessage()
    {
        return developerMessage;
    }

    /**
     * @return The userMessage.
     */
    public String getUserMessage()
    {
        return userMessage;
    }

        /**
     * @return The internalMessage.
     */
    public String getInternalMessage()
    {
        return internalMessage;
    }

    /**
     * @return The validationErrors.
     */
    public List<FSValidationError> getValidationErrors()
    {
        return validationErrors;
    }
}
