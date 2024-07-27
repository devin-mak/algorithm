package com.wheat.algorithm.base.greedy;

import cn.hutool.core.lang.Assert;

/**
 * @author maij
 * @description:
 * @date 2023-11-09 16:05
 **/
public class PartitioningIntoMinimumNumberOfDeciBinaryNumbers {

    public static void main(String[] args) {
        Assert.equals(minPartitions("32"), 3);
        Assert.equals(minPartitions("82734"), 8);
        Assert.equals(minPartitions("27346209830709182346"), 9);
    }

    public static int minPartitions(String n) {
        char[] charArray = n.toCharArray();
        int max = 48;
        for (char c : charArray) {
            if (max < c) {
                max = c;
            } else if (max == 57) {
                break;
            }
        }
        return max - 48;
    }
}
