package com.sychev.events.exception;

public class NotFoundHistoriesException extends RuntimeException {

    public NotFoundHistoriesException() {
    }

    public NotFoundHistoriesException(String message) {
        super(message);
    }
}
