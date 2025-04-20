package com.design.pattern.java.gemini;

import java.util.HashMap;
import java.util.Map;

// 1. 할인 정책 인터페이스 및 구현 클래스
interface DiscountStrategy {
    int applyDiscount(int price);
}

class PercentageDiscountStrategy implements DiscountStrategy {
    private int percentage;

    public PercentageDiscountStrategy(int percentage) {
        this.percentage = percentage;
    }

    @Override
    public int applyDiscount(int price) {
        // 구현하세요
        return 0;
    }
}

class AmountDiscountStrategy implements DiscountStrategy {
    private int discountAmount;

    public AmountDiscountStrategy(int discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public int applyDiscount(int price) {
        // 구현하세요
        return 0;
    }
}

class MaxDiscountStrategy implements DiscountStrategy {
    private DiscountStrategy percentageDiscount;
    private DiscountStrategy amountDiscount;

    public MaxDiscountStrategy(DiscountStrategy percentageDiscount, DiscountStrategy amountDiscount) {
        this.percentageDiscount = percentageDiscount;
        this.amountDiscount = amountDiscount;
    }

    @Override
    public int applyDiscount(int price) {
        // 구현하세요
        return 0;
    }
}

// 2. 할인 정책 팩토리
class DiscountStrategyFactory {
    private static final Map<String, DiscountStrategy> strategies = new HashMap<>();

    static {
        // 구현하세요
    }

    public static DiscountStrategy getStrategy(String strategyName) {
        // 구현하세요
        return null;
    }
}

// 3. 주문 클래스
class Order {
    private int price;

    public Order(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void applyDiscount(DiscountStrategy strategy) {
        this.price = strategy.applyDiscount(this.price);
    }
}

// 4. 주문 처리 시뮬레이션
class OrderSystem {
    public static void main(String[] args) {
        Order order = new Order(10000);

        DiscountStrategy percentageDiscount = DiscountStrategyFactory.getStrategy("PERCENTAGE");
        order.applyDiscount(percentageDiscount);
        System.out.println("Price after percentage discount: " + order.getPrice());

        DiscountStrategy amountDiscount = DiscountStrategyFactory.getStrategy("AMOUNT");
        order.applyDiscount(amountDiscount);
        System.out.println("Price after amount discount: " + order.getPrice());

        DiscountStrategy maxDiscount = DiscountStrategyFactory.getStrategy("MAX");
        order.applyDiscount(maxDiscount);
        System.out.println("Price after max discount: " + order.getPrice());
    }
}
