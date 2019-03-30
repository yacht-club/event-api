package com.sychev.events.exception;

public class NotFoundTaskException extends RuntimeException {

    public NotFoundTaskException() {
    }

    public NotFoundTaskException(String message) {
        super(message);
    }
}
