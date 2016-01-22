package com.menil.jahulk.bus;

/**
 * Created by Menil V. on 22.1.2016 at com.menil.jahulk.bus.
 */
public class SuccessEvent {
    private String message;

    public SuccessEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public SuccessEvent setMessage(String message) {
        this.message = message;
        return this;
    }
}
