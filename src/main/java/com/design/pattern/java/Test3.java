package com.design.pattern.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

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



        class Solution {
            public boolean isPalindrome(int x) {
                String str = Integer.toString(x);
                int len = str.length();
                for (int i = 0; i < len / 2; i++) {
                    if (str.charAt(i) != str.charAt(len - i - 1)) {
                        return false;
                    }
                }

                return true;
            }
        }

        List<Integer> list = new ArrayList<>();
        list.add(2);list.add(4);list.add(3);
        //list reverse 만들기 stream 사용
        Collections.reverse(list);
//        System.out.println(list);

        String a = "";
        for (Integer i : list) {
            a += i;
        }
//        System.out.println(a);


        String s = "dvdf"; // 5
        int max = 0;
        int left = 0;
        Set<Character> set = new HashSet<>();

        char temp = 0;

        for (int right=0; right<s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                // System.out.println("1 set = " + set);
                set.remove(s.charAt(left));
                // System.out.println("2 set = " + set);
                left++;
            }
            // System.out.println("3 set = " + set);
            set.add(s.charAt(right));
            // System.out.println("4 set = " + set);
            max = Math.max(max, set.size());
            // System.out.println("max = " + max);
        }

        System.out.println(max);
    }
    public int lengthOfLongestSubstring(String s3) {

        return 0;
    }

}
