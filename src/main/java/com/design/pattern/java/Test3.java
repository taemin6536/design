package com.design.pattern.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test3 {
    public static void main(String[] args) {
        reverseString(new char[]{'h', 'e', 'l', 'l', 'o'});
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
}
