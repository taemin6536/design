package com.design.pattern.java;


import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

public class Test {
    class Solution1 {
        static int zeroCount = 0;
        static int count = 0;

        public int[] solution2(String s) {
            while (!s.equals("1")) {
                int length = s.length();
                s = s.replace("0", "");
                zeroCount += length - s.length();
                System.out.println(s);
                System.out.println(s.length());
                s = Integer.toBinaryString(s.length());
                count++;
            }

            return new int[]{count, zeroCount};
        }

        static String a = "(";
        static String b = "[";
        static String c = "{";

        static String d = ")";
        static String e = "]";
        static String f = "}";

        public int solution3(String s) {
            int result = 0;
            s = s.trim();
            Queue<String> queue = new LinkedList<>();
            for (int i = 0; i < s.length(); i++) {
                queue.add(s.substring(i, i + 1));
            }

            for (int i = 0; i < queue.size(); i++) {
                boolean correct = isCorrect(queue);
                if (correct) {
                    result++;
                }

                String poll = queue.poll();
                queue.add(poll);
            }

            return result;
        }

        private boolean isCorrect(Queue<String> queue) { // ( ) ( ( ) ( ( ) ( ) ) ( ) )
            Queue<String> tempQueue = new LinkedList<>();
            Stack<String> stack = new Stack<>();
            tempQueue = new LinkedList<>(queue);

            if (queue.size() % 2 != 0) {
                return false;
            }

            //하나씩 temp큐에 삽입
            for (int i = 0; i < queue.size(); i++) {
                String poll = tempQueue.poll();

                if (stack.isEmpty()) {
                    stack.push(poll);
                } else {
                    String peek = stack.peek();
                    if (peek.equals(a) && poll.equals(d)) {
                        stack.pop();
                    } else if (peek.equals(b) && poll.equals(e)) {
                        stack.pop();
                    } else if (peek.equals(c) && poll.equals(f)) {
                        stack.pop();
                    } else {
                        stack.push(poll);
                    }
                }
            }
            return stack.isEmpty();
        }


        static int solution(int[] A, int[] B) {
            int count = A.length;
            int sum = 0;

//        int[] array = Arrays.stream(A).sorted().toArray();
            int[] array2 = Arrays.stream(B)
                    .boxed()
                    .sorted(Collections.reverseOrder())
                    .mapToInt(Integer::intValue)
                    .toArray();

            for (int i = 0; i < count; i++) {
//            sum += array[i] * array2[i];
                //A의 최솟값과 B의 최댓값을 곱해서 더해준다.
                int a = Arrays.stream(A).min().getAsInt();
                int b = Arrays.stream(B).max().getAsInt();
                sum += a * b;
                //배열에서 제거한다 뺀 값들은 배열에서 하나만 제거


//            A = Arrays.stream(A).filter(value -> value != a).toArray();
            }


            System.out.println(sum);

            return sum;
        }

        public static int[] removeMinValues(int[] arr) {
            List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());

            while (list.size() > 1) {
                int minValue = list.get(0);
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) < minValue) {
                        minValue = list.get(i);
                    }
                }
                list.remove((Integer) minValue);
            }
            return list.stream().mapToInt(Integer::intValue).toArray();
        }
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Test().new Solution1();
        int i = solution1.solution3("(({[]}))");
        System.out.println(i);
    }
}
