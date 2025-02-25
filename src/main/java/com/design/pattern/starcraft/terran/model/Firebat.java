package com.design.pattern.starcraft.terran.model;

public class Firebat implements Unit {
    @Override
    public void attack() {
        System.out.println("파이어뱃이 공격합니다.");
    }

    @Override
    public String getUnitType() {
        return "파이어뱃";
    }
}
