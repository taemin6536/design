package com.design.pattern.java.dynamic;

public class AppleHeavyWeightPredicate implements ApplePredicate{
    public boolean test(Apple apple) {
        return apple.getWeight()>150;
    }
}
