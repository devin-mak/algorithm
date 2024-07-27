package com.wheat.algorithm.base.greedy;

/**
 * @author maij
 * @description:
 * @date 2023-11-06 10:09
 **/
public class SplitAStringInBalancedStrings {

    private static final char R_CHAR = 'R';

    public static void main(String[] args) {
        System.out.println(balancedStringSplit("LLLLRRRR"));
    }

    public static int balancedStringSplit(String s) {
        char[] charArray = s.toCharArray();
        int maximum = 0;
        int rNum = 0;
        int lNum = 0;
        for (char c : charArray) {
            if (R_CHAR == c) {
                ++rNum;
            } else {
                ++lNum;
            }
            if (rNum == lNum) {
                ++maximum;
                rNum = 0;
                lNum = 0;
            }
        }
        return maximum;
    }
}
