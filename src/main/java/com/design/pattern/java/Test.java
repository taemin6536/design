package com.design.pattern.java;


public class Test {
    public static void main(String[] args) {
        System.out.println("Hello World");

        Test2.staticMethod();

        Test2 test2 = new Test2();

        test2.protectedMethod();

        test2.defaultMethod();
    }
}

class Test2 {
    public static void main(String[] args) {
        System.out.println("Hello World");

        Test2 test2 = new Test2();
        test2.privateMethod();

        Test2.staticMethod();
    }


    public static void staticMethod() {
        System.out.println("static method");
//        return "static method";
    }

    protected void protectedMethod() {
        System.out.println("protected method");
    }
    private void privateMethod() {
        System.out.println("private method");
    }
    void defaultMethod() {
        System.out.println("default method");
    }

    public void defaultMethod2() {
        System.out.println("default method");
    }
}
