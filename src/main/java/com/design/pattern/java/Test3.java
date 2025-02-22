package com.design.pattern.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test3 {
    public static void main(String[] args) {
        // ArithmeticException예제
//        int a = 10;
//        int b = 0;
//
//        try {
//            int c = a / b;
//        } catch (ArithmeticException e) {
//            System.out.println("ArithmeticException");
//        } catch (Exception e) {
//            System.out.println("Exception");
//        } finally {
//            System.out.println("Finally");
//        }

        //동등성과 동일성
        // 동등성은 위치, 동일성은 형태?
        // 동일성은 값 그자체가 같은가? == 연산자로 비교
        // 동등성은 객체의 해시코드가 같은가? hashcode ? : 메모리 주소 기반 임의의 정수값  equals()

        // 8234576235
//        Person p = new Person("taemin");
//        // 2634757234
//        Person p2 = new Person("taemin");
//
//        System.out.println(p.equals(p2));
//        System.out.println(p == p2);

        //nullpointerexception 예제
        String str = null;
        try {
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException");
        } catch (Exception e) {
            System.out.println("Exception");
        } finally {
            //db connection close

        }

    }
}
