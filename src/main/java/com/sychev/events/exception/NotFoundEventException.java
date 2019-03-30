package com.sychev.events.exception;

public class NotFoundEventException extends RuntimeException {

    public NotFoundEventException() {
    }

    public NotFoundEventException(String message) {
        super(message);
    }
}
