package com.design.pattern.strategy.item;

// 1. 전략 인터페이스
public interface PaymentStrategy {
    void processPayment(Order order);
}
