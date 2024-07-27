package com.wheat.algorithm.base.greedy;

import java.util.Arrays;

/**
 * @author maij
 * @description:
 * @date 2023-11-06 17:11
 **/
public class DIStringMatch {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(diStringMatch("IDID")));
        System.out.println(Arrays.toString(diStringMatch("III")));
        System.out.println(Arrays.toString(diStringMatch("DDI")));
    }

    public static int[] diStringMatch(String s) {
        char[] charArray = s.toCharArray();
        int min = 0;
        int max = charArray.length;
        int[] result = new int[charArray.length + 1];
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == 'I') {
                result[i] = min++;
            } else {
                result[i] = max--;
            }
        }
        result[charArray.length] = min;
        return result;
    }
}
