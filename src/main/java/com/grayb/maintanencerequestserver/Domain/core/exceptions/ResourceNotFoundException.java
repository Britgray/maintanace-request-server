package com.grayb.maintanencerequestserver.Domain.core.exceptions;

public class ResourceNotFoundException extends Throwable {
    public ResourceNotFoundException(String message){
        super(message);
    }

}
