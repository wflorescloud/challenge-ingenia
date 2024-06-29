package com.challenge.ingenia.demo.exceptions;



public class ResourceNotFoundException extends RuntimeException {

    private final String appCode;

    public ResourceNotFoundException(String message,String appCode) {
        super(message);
        this.appCode = appCode;
    }

    public String getAppCode() {
        return appCode;
    }
}
