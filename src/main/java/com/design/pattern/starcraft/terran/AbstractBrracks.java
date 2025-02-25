package com.design.pattern.starcraft.terran;

import com.design.pattern.starcraft.terran.model.Unit;

import java.util.ArrayList;
import java.util.List;

abstract class AbstractBrracks implements Barracks{
    protected List<Unit> units = new ArrayList<>();

    @Override
    public void displayUnits() {
        System.out.println("=== Barracks Units ===");
        for (Unit unit : units) {
            System.out.println(unit.getUnitType());
        }
    }
}
