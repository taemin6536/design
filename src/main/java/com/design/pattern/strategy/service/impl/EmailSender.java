package com.design.pattern.strategy.service.impl;

import com.design.pattern.strategy.enums.MessageType;
import com.design.pattern.strategy.service.MessageSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@RequiredArgsConstructor
public class EmailSender implements MessageSenderService {
    @Override
    public MessageType getMessageType() {
        return MessageType.EMAIL;
    }

    @Override
    public void sendMessage(String message) {
        if (!StringUtils.hasText(message)){
            throw new NullPointerException();
        }
        System.out.println("Sending Email: " + message);
    }
}
