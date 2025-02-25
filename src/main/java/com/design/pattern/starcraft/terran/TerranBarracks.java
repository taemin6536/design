package com.design.pattern.starcraft.terran;

import com.design.pattern.starcraft.terran.model.Firebat;
import com.design.pattern.starcraft.terran.model.Marine;
import com.design.pattern.starcraft.terran.model.Medic;
import com.design.pattern.starcraft.terran.model.Unit;

public class TerranBarracks extends AbstractBrracks{
    @Override
    public Unit produceUnit(String unitType) {
        Unit unit;
        switch (unitType.toLowerCase()) {
            case "marine":
                unit = new Marine();
                break;
            case "firebat":
                unit = new Firebat();
                break;
            case "medic":
                unit = new Medic();
                break;
            default:
                throw new IllegalArgumentException("Unknown unit type: " + unitType);
        }
        units.add(unit);
        System.out.println(unitType + " produced!");
        return unit;
    }
}
