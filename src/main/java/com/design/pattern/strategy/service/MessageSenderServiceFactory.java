package com.design.pattern.strategy.service;

import com.design.pattern.strategy.enums.MessageType;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class MessageSenderServiceFactory {
    private Map<MessageType, MessageSenderService> serviceTypeMap = new EnumMap<>(MessageType.class);

    public MessageSenderServiceFactory(final Set<MessageSenderService> services) {
        registerServices(services);
    }

    /* 단일 책임의 원칙으로 생성자는 등록서비스를 등록하는 프로세스를 시작하는 역할만 함 */
    private void registerServices(final Set<MessageSenderService> services) {
        this.serviceTypeMap = services.stream()
                .collect(Collectors.toMap(
                        MessageSenderService::getMessageType,
                        service -> service
                ));
    }

    /* 메소드를 분리함으로써 테스트에 용이하게됨 */
    private void registerService(MessageSenderService messageSenderService) {
        MessageType messageType = messageSenderService.getMessageType();
        serviceTypeMap.put(messageType, messageSenderService);
    }

    public MessageSenderService getMessageSenderService(final MessageType messageType){
        return serviceTypeMap.get(messageType);
    }

}
