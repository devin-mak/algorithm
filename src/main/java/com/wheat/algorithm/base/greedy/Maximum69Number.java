package com.wheat.algorithm.base.greedy;

import cn.hutool.core.lang.Assert;

/**
 * @author maij
 * @description:
 * @date 2023-11-06 10:36
 **/
public class Maximum69Number {

    public static void main(String[] args) {
        Assert.equals(maximum69Number(9669), 9969);
        Assert.equals(maximum69Number(9996), 9999);
        Assert.equals(maximum69Number(9999), 9999);
    }

    public static int maximum69Number (int num) {
        char[] charArray = String.valueOf(num).toCharArray();
        int digit = charArray.length;
        int position = digit;
        for (int i = 0; i < digit; i++) {
            if (charArray[i] == '6') {
                position = i;
                break;
            }
        }
        return num + 3 * power(10, digit - position - 1);
    }

    private static int power(int num, int power) {
        if (power < 0) {
            return 0;
        }

        if (power == 0) {
            return 1;
        }

        int temp = num;
        for (int i = 1; i < power; i++) {
            num = num * temp;
        }
        return num;
    }
}
