package com.design.pattern.sealed;

public sealed class Vehicle permits Car, Bike, Truck {
    public void drive() {
        System.out.println("Driving Vehicle");
    }
}
