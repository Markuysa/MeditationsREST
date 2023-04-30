package com.example.meditationsrest_main.exceptions;

public class ResourceNotFoundException extends Throwable{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
