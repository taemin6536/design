package com.design.pattern.starcraft.terran.model;

public class Marine implements Unit {
    private boolean hasStimpack = false;
    private int health = 100;
    private int attackPower = 6;

    @Override
    public void attack() {
        System.out.println("Marine: Pew Pew! (Attack Power: " + attackPower + ")");
    }

    @Override
    public String getUnitType() {
        return "Marine";
    }

    //스팀팩 기능 추가
    public void useStimpack() {
        if (!hasStimpack) {
            if (health > 10) { // 체력이 충분해야 사용 가능
                health -= 10;  // 체력 감소
                attackPower *= 2; // 공격력 증가
                hasStimpack = true;
                System.out.println("Marine used Stimpack! (HP: " + health + ", Attack Power: " + attackPower + ")");
            } else {
                System.out.println("Marine is too weak to use Stimpack!");
            }
        } else {
            System.out.println("Marine already used Stimpack!");
        }
    }
}
