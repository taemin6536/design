package com.design.pattern.strategy.item;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

// 3. 컨텍스트
@Service
public class OrderService {

    private final Map<String, PaymentStrategy> paymentStrategies = new HashMap<>();

    public OrderService(PGPaymentStrategy pgPaymentStrategy, TransferPaymentStrategy transferPaymentStrategy) {
        paymentStrategies.put("PG", pgPaymentStrategy);
        paymentStrategies.put("TRANSFER", transferPaymentStrategy);
    }

    public void processOrder(Order order, String paymentMethod) {
        PaymentStrategy paymentStrategy = paymentStrategies.get(paymentMethod);
        paymentStrategy.processPayment(order);
    }
}
