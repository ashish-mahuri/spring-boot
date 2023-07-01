package com.springboot.crud.demo.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ResourceNotFound extends RuntimeException {

    private static final long serialVersionID = 1;
    public ResourceNotFound(String message) {
        super(message);
    }

    public ResourceNotFound(String message, Throwable throwable) {
        super(message, throwable);
    }
}
