package com.design.pattern.starcraft.terran;

import com.design.pattern.starcraft.terran.model.Unit;

public interface Barracks {
    Unit produceUnit(String unitType);
    void displayUnits();
}
