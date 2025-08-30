package com.example.springbootcommon.exception;

public class ValidationException extends BaseException {
    public ValidationException(String message) {
        super(400, message);
    }

    public ValidationException(String message, Throwable cause) {
        super(400, message, cause);
    }
}