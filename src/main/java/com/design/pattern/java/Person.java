package com.design.pattern.java;

import lombok.Builder;
import lombok.Data;

import java.util.Objects;


/*
* GC (Garbage Collection)
* 1. 객체가 더이상 사용되지 않을 때 메모리에서 해제하는 기능
*
* */



@Data
public class Person {
    private String name;
    private String age;

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public Person() {}

    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    //    public Person(String name) {
//        this.name = name;
//    }

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
