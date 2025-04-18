package com.design.pattern.strategy.item;

// 2. 구체적인 전략
public class PGPaymentStrategy implements PaymentStrategy {
    @Override
    public void processPayment(Order order) {
        // PG 연동 로직
    }
}
