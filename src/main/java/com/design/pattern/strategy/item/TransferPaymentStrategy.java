package com.design.pattern.strategy.item;

public class TransferPaymentStrategy implements PaymentStrategy {
    @Override
    public void processPayment(Order order) {
        // 무통장 입금 처리 로직
    }
}
