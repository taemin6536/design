package com.design.pattern.starcraft.terran.model;

public class Medic implements Unit {
    @Override
    public void attack() {
        System.out.println("메딕이 치료합니다.");
    }

    @Override
    public String getUnitType() {
        return "메딕";
    }
}
