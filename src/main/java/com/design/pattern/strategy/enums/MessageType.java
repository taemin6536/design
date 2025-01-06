package com.design.pattern.strategy.enums;

public enum MessageType {
    EMAIL("email"),
    SMS("sms"),
    PUSH_NOTIFICATION("push");

    private final String type;

    MessageType(final String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

