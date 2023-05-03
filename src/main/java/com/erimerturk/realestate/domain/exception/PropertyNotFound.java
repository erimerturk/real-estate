package com.erimerturk.realestate.domain.exception;

public class PropertyNotFound extends RuntimeException {

    public PropertyNotFound(String message) {
        super(message);
    }

}