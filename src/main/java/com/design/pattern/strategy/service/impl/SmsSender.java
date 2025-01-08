package com.design.pattern.strategy.service.impl;

import com.design.pattern.strategy.enums.MessageType;
import com.design.pattern.strategy.service.MessageSenderService;
import org.springframework.stereotype.Component;

@Component
public class SmsSender implements MessageSenderService {
    @Override
    public MessageType getMessageType() {
        return MessageType.SMS;
    }

    @Override
    public void sendMessage(String message) {
        System.out.println("Sending SMS: " + message);
    }
}
