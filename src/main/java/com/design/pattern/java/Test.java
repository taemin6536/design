package com.design.pattern.java;


public class Test {
    public static void main(String[] args) {
        System.out.println("Hello World");

        Test2.staticMethod();

        Test2 test2 = new Test2();

        test2.protectedMethod();

        test2.defaultMethod();


        Person person = new Person("태민", "12");

        //SOLID
        //SRP : 단일 책임 원칙
        //OCP : 개방 폐쇄 원칙
        //LSP : 리스코프 치환 원칙 -> 자식이 부모를 대체할 수 있어야 한다. 부모를 상속받잖아 자식은 자식은 부모의 기능을 가지잖아 extends  무조건 부모를 대신해서 들어가도 동일하게 동작해야해. 그런데 이걸 위배하는 상황 직사각형 정사각형       상속을 잘못 사용하면 다형성이 깨지고, 코드의 일관성  직사각형 세로 가로 정사각형 세로 가로 길이 같아야 정사각형이야 그런데 부모는 세로 따로 가로따로 x 두개 함께수정  abstract class 이 사이에 두는거야 가로세로함께수정메소드()
        //ISP : 인터페이스 분리 원칙
        //DIP : 의존 역전 원칙

    }
}

class Test2 {
    public static void main(String[] args) {
        System.out.println("Hello World");

        Test2 test2 = new Test2();
        test2.privateMethod();

        Test2.staticMethod();

        test2.defaultMethod2("");
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

    public void defaultMethod2(String str) {
        System.out.println("default" + str);
    }

    public void defaultMethod2(String str, int a) {
        System.out.println("default" + str);
    }

    public void defaultMethod2(int a, String str) {
        System.out.println("default" + str);
    }



























}
