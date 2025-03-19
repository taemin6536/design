package com.design.pattern.sealed.game;

public class main {
    public String describeCharacter(CharacterType character) {
        return switch (character) {
            case Warrior w -> "Warrior with strength " + w.strength();
            case Mage m -> "Mage with mana " + m.mana();
            case Archer a -> "Archer with agility " + a.agility();
            //케이스가 추가되면 컴파일 오류 발생
        };
    }

    //sealed 사용하여 게임 캐릭터 유형을 강제
    //record 활용하여 객체를 불변으로 유지
    //새로운 캐릭터 유형이 추가될 경우, switch 에서 컴파일 오류 발생 → 유지보수 용이
    public static void main(String[] args) {
        main m = new main();
        System.out.println(m.describeCharacter(new Warrior(10, 5)));
        System.out.println(m.describeCharacter(new Mage(10, 5)));
        System.out.println(m.describeCharacter(new Archer(10, 5)));
    }
}
