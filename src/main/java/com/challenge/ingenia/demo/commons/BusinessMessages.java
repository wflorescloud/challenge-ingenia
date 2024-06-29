package com.challenge.ingenia.demo.commons;

public class BusinessMessages {
    public enum CodeService {
        CODE_PATH_0100("No paths found for the provided source and destination ids");

        private final String message;
        CodeService(String message) {
            this.message = message;
        }
        public String getMessage() {
            return message;
        }
    }
}
