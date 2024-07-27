package com.wheat.algorithm.base.greedy;

import cn.hutool.core.lang.Assert;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author maij
 * @description:
 * @date 2023-11-08 11:54
 **/
public class MaximumUnitsOnATruck {

    public static void main(String[] args) {
        int[][] boxTypes1 = {{1, 3}, {2, 2}, {3, 1}};
        Assert.equals(maximumUnits(boxTypes1, 4), 8);

        int[][] boxTypes2 = {{5, 10}, {2, 5}, {4, 7}, {3, 9}};
        Assert.equals(maximumUnits(boxTypes2, 10), 91);
    }

    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, Comparator.comparingInt(o -> o[1]));
        int total = 0;
        for (int i = boxTypes.length - 1; i >= 0 && truckSize > 0; i--) {
            int num = Math.min(boxTypes[i][0], truckSize);
            total += num * boxTypes[i][1];
            truckSize -= num;
        }
        return total;
    }

    public static int maximumUnits2(int[][] boxTypes, int truckSize) {
        int max = 0;
        for (int[] boxType : boxTypes) {
            if (max < boxType[1]) {
                max = boxType[1];
            }
        }
        if (max == 0) {
            return 0;
        }
        int[] boxArray = new int[max + 1];
        for (int[] boxType : boxTypes) {
            boxArray[boxType[1]] += boxType[0];
        }
        int total = 0;
        for (int i = boxArray.length - 1; i >= 0 && truckSize > 0; i--) {
            int type = boxArray[i];
            if (type == 0) {
                continue;
            }
            int num = Math.min(type, truckSize);
            total += num * i;
            truckSize -= num;
        }
        return total;
    }
}
