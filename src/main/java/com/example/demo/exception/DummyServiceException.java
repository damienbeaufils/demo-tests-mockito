package com.example.demo.exception;

public class DummyServiceException extends RuntimeException {
    public DummyServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
