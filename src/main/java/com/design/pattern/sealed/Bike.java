package com.design.pattern.sealed;

public sealed class Bike extends Vehicle permits MountainBike, RoadBike {
    public void drive() {
        System.out.println("Driving Bike");
    }
}
