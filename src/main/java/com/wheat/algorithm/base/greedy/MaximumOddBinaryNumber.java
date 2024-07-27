package com.wheat.algorithm.base.greedy;

import cn.hutool.core.lang.Assert;

/**
 * @author maij
 * @description:
 * @date 2023-11-09 15:34
 **/
public class MaximumOddBinaryNumber {

    public static void main(String[] args) {
        Assert.equals(maximumOddBinaryNumber("010"), "001");
        Assert.equals(maximumOddBinaryNumber("0101"), "1001");
    }

    public static String maximumOddBinaryNumber(String s) {
        char[] charArray = s.toCharArray();
        int length = charArray.length;
        int oneCharNum = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '1') {
                oneCharNum++;
                charArray[i] = '0';
            }
        }
        for (int i = 0; i < oneCharNum - 1; i++) {
            charArray[i] = '1';
        }
        charArray[length - 1] = '1';
        return new String(charArray);
    }
}
