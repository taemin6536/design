package com.design.pattern.java.dynamic;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {

    }

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result=new ArrayList<>();

        for (Apple apple : result) {
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;

    }

    public void test123() {
        List<Apple> redAndHeavyApples=filterApples(inventory ,new AppleGreenColorPredicate());
    }
}
