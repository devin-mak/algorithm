package com.wheat.algorithm.base.greedy;

import cn.hutool.core.lang.Assert;

import java.util.Arrays;

/**
 * @author maij
 * @description:
 * @date 2023-11-06 16:26
 **/
public class ArrayPartition {

    public static void main(String[] args) {
        int[] nums1 = {1,4,3,2};
        Assert.equals(arrayPairSum(nums1), 4);

        int[] nums2 = {6,2,6,5,1,2};
        Assert.equals(arrayPairSum(nums2), 9);
    }

    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            max += nums[i];
        }
        return max;
    }
}
