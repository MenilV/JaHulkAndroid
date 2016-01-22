package com.menil.jahulk.bus.error;

/**
 * Created by Menil V. on 22.1.2016 at com.menil.jahulk.bus.error.
 */
public class ErrorEvent {
    private String message;

    public ErrorEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public ErrorEvent setMessage(String message) {
        this.message = message;
        return this;
    }
}
