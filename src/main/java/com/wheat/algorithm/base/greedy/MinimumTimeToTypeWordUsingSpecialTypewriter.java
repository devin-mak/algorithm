package com.wheat.algorithm.base.greedy;

/**
 * @author maij
 * @description:
 * @date 2023-11-06 17:29
 **/
public class MinimumTimeToTypeWordUsingSpecialTypewriter {

    public static void main(String[] args) {
        System.out.println(minTimeToType("abc"));
        System.out.println(minTimeToType("bza"));
        System.out.println(minTimeToType("zjpc"));
    }

    public static int minTimeToType(String word) {
        char[] charArray = word.toCharArray();
        char startChar = 'a';
        int num = 0;
        for (char c : charArray) {
            int distance = Math.abs(c - startChar);
            num += Math.min(distance, 26 - distance) + 1;
            startChar = c;
        }
        return num;
    }
}
