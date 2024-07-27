package com.wheat.algorithm.base.array;

/**
 * @author maij
 * @description:
 * @date 2024-07-06 16:05
 **/
public class StringMoveK {

    public String rotate(String s, int k) {
        char[] charArray = s.toCharArray();
        int i = k / charArray.length;
        for (int j = 0; j < charArray.length - i - 1; j++) {
            int temp = charArray[j];

        }
        return null;
    }
}
