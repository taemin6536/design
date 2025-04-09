package com.design.pattern.java;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

public class Test3 {
    static {

    }
    public static void main(String[] args) {



        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                for (int i = 0; i < 5; i++) {
                    toolkit.beep();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        thread.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("DDIDIDIDINGGGG");

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("","");

        Deque<Integer> a = new ArrayDeque<>();

        Stack<Integer> b = new Stack<>();
    }



    public static <T> Box<T> createBox(T value) {
        Box<T> box = new Box<>();
        box.setValue(value);
        return box;
    }


    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        return new StringBuilder(s).reverse().toString().equals(s);
    }

    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }

    public String[] reorderLogFiles(String[] logs) {
        List<String> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();

        for (String log : logs) {
            if (Character.isDigit(log.split(" ")[1].charAt(0))) {
                digitLogs.add(log);
            } else {
                letterLogs.add(log);
            }
        }

        letterLogs.sort((s1, s2) -> {
            String[] split1 = s1.split(" ", 2);
            String[] split2 = s2.split(" ", 2);

            int compare = split1[1].compareTo(split2[1]);
            if (compare == 0) {
                return split1[0].compareTo(split2[0]);
            }
            return compare;
        });

        letterLogs.addAll(digitLogs);

        return letterLogs.toArray(new String[0]);
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.replaceAll("\\W+", " ").toLowerCase().split(" ");
        Set<String> set = new HashSet<>(Arrays.asList(banned));

        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            if (!set.contains(word)) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> results = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = Arrays.toString(chars);

            if (!results.containsKey(key)) {
                results.put(key, new ArrayList<>());
            }

            results.get(key).add(str);
        }
        return new ArrayList<>(results.values());
    }

    int left, maxLen;

    public void extendPalindrome(String s, int j, int k){
        while(j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)){
            j--;
            k++;
        }

        if (maxLen < k - j -1) {
            left = j +1;
            maxLen = k - j - 1;
        }
    }

    public String longestPalindrome(String s) {
        int len = s.length();

        if (len < 2) return s;

        for (int i = 0; i < len -1; i++) {
            extendPalindrome(s, i, i+1);
            extendPalindrome(s, i, i+2);
        }
        return s.substring(left, left + maxLen);
    }

    public int trap(int[] height) {
        int volume = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];

        while(left < right){
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);

            if (leftMax <= rightMax){
                volume += leftMax - height[left];
                left += 1;
            }else{
                volume += rightMax - height[right];
                right -= 1;
            }
        }
        return volume;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int left, right, sum;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }

            left = i + 1;
            right = nums.length - 1;
            while(left < right) {
                sum = nums[i] + nums[left] + nums[right];

                if (sum < 0){
                    left += 1;
                }else if (sum > 0){
                    right -= 1;
                }else{
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while(left<right && nums[left] == nums[left +1]){
                        left += 1;
                    }
                    while(left<right && nums[right] == nums[right -1]){
                        right -= 1;
                    }

                    left += 1;
                    right -= 1;
                }
            }
        }
        return  result;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedArray = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, mergedArray, 0, nums1.length);
        System.arraycopy(nums2, 0, mergedArray, nums1.length, nums2.length);
        Arrays.sort(mergedArray);

        if (mergedArray.length % 2 != 0){
            return mergedArray[mergedArray.length / 2];
        }else {
            return ((double) mergedArray[mergedArray.length/2] + (double) mergedArray[mergedArray.length / 2 - 1]) / 2;
        }

    }

    public int maxProfit(int[] prices) {
        int max = 0;
        int minPrice = prices[0];

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            max = Math.max(max, price - minPrice);
        }
        return max;
    }

    public boolean isPalindrome(ListNode head) {
        Deque<Integer> deque = new LinkedList<>();

        ListNode node = head;

        while(node != null){
            deque.add(node.val);
            node = node.next;
        }

        while(!deque.isEmpty() && deque.size() > 1){
            if (deque.pollFirst() != deque.pollLast()){
                return false;
            }
        }
        return true;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode result = new ListNode();

        Deque<Integer> stack = new LinkedList<>();
        ListNode node = head;
        while(node != null){
            stack.push(node.val);
            node = node.next;
        }

        while(!stack.isEmpty()){
            ListNode newNode = new ListNode(stack.pollLast());
            newNode.next = result.next;
            result.next = newNode;
        }
        return result.next;
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        //홀수 노드
        ListNode odd = head;
        //짝수 노드
        ListNode even = head.next;
        //짝수 첫번쨰 노드
        ListNode evenHead = even;

        //반복하면서 홀짝 노드 처리
        while(even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

}
