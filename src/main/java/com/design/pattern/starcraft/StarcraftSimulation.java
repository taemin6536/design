package com.design.pattern.starcraft;

import com.design.pattern.starcraft.terran.Barracks;
import com.design.pattern.starcraft.terran.TerranBarracks;
import com.design.pattern.starcraft.terran.model.Marine;
import com.design.pattern.starcraft.terran.model.Unit;

public class StarcraftSimulation {
    public static void main(String[] args) {
        Barracks barracks = new TerranBarracks();

        Unit firebat = barracks.produceUnit("firebat");
        Unit marine = barracks.produceUnit("marine");
        Unit medic = barracks.produceUnit("medic");

//        barracks.produceUnit("ghost");  IllegalArgumentException 발생
        barracks.displayUnits();

        //스팀팩 기능 추가
        marine.attack(); // 기본 공격력 6
        if (marine instanceof Marine) {
            ((Marine) marine).useStimpack(); // 스팀팩 사용 -> 공격력 12, 체력 감소
        }
        marine.attack(); // 스팀팩 적용된 공격력 12
        marine.attack();
        if (marine instanceof Marine) {
            ((Marine) marine).useStimpack(); // 스팀팩 사용 -> 공격력 12, 체력 감소
        }
    }
}
