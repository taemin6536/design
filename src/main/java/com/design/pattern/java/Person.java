package com.design.pattern.java;

import java.util.Objects;


/*
* GC (Garbage Collection)
* 1. 객체가 더이상 사용되지 않을 때 메모리에서 해제하는 기능
*
* */



public class Person {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }


}
