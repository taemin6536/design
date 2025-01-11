package com.design.pattern.strategy;

import com.design.pattern.strategy.enums.MessageType;
import com.design.pattern.strategy.service.impl.EmailSender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class StrategyTests {
    private EmailSender emailSender;

    @BeforeEach
    void setUp(){
        emailSender = new EmailSender();
    }

    @Test
    @DisplayName("메세지 타입이 이메일인가?")
    void 메세지_타입이_이메일인가(){
        MessageType messageType = emailSender.getMessageType();
        assertThat(messageType).isEqualTo(MessageType.EMAIL);
    }

    @Test
    @DisplayName("메시지 전송 시 예외가 발생하지 않아야 함")
    void 메세지_예외처리(){
        String message = "Test Message";

        assertDoesNotThrow(() -> emailSender.sendMessage(message));
    }

    @Test
    @DisplayName("null 메시지 전송 시 NullPointerException 발생해야 함")
    void 널_메시지_전송() {
        // given
        String nullMessage = null;

        // when & then
        assertThrows(NullPointerException.class, () ->
                emailSender.sendMessage(nullMessage)
        );
    }
}
