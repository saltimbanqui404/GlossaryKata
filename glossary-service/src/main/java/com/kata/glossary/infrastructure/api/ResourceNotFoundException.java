package com.kata.glossary.infrastructure.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException  {

    private String message;

    public ResourceNotFoundException() {}

    public ResourceNotFoundException(String currentMessage){
        super(currentMessage);
        this.message = currentMessage;
    }

}

