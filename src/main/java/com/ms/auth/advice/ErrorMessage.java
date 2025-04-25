package com.ms.auth.advice;

import java.time.Instant;

public class ErrorMessage {

    private final int statusCode;
    private final Instant timestamp;
    private final String message;
    private final String description;

    public ErrorMessage(int statusCode, Instant timestamp, String message, String description) {
        this.statusCode = statusCode;
        this.timestamp = timestamp;
        this.message = message;
        this.description = description;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }
}
