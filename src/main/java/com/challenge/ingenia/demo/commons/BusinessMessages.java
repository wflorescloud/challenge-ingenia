package com.challenge.ingenia.demo.commons;

public class BusinessMessages {
    public enum CodeService {
        CODE_PATH_0100("No paths found for the provided source and destination ids"),
        CODE_STATION_0100("Source station not found"),
        CODE_STATION_0200("Destination station not found");

        private final String message;
        CodeService(String message) {
            this.message = message;
        }
        public String getMessage() {
            return message;
        }
    }
}
