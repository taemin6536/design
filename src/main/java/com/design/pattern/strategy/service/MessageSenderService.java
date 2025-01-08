package com.design.pattern.strategy.service;

import com.design.pattern.strategy.enums.MessageType;

public interface MessageSenderService {
    MessageType getMessageType();
    void sendMessage(String message);
}
