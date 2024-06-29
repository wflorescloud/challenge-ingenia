package com.challenge.ingenia.demo.model;

import java.sql.Timestamp;
import java.time.Instant;

public class ErrorResponse {
    private String appCode;
    private String message;
    private final Timestamp timestamp;

    public ErrorResponse(String appCode, String message) {
        this.appCode = appCode;
        this.message = message;
        this.timestamp = Timestamp.from(Instant.now());
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }
}
