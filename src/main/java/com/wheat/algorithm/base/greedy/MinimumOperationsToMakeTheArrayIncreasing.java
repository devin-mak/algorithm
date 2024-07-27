package com.wheat.algorithm.base.greedy;

import cn.hutool.core.lang.Assert;

/**
 * @author maij
 * @description:
 * @date 2023-11-06 11:46
 **/
public class MinimumOperationsToMakeTheArrayIncreasing {

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1};
        Assert.equals(minOperations(nums1), 3);

        int[] nums2 = {1,5,2,4,1};
        Assert.equals(minOperations(nums2), 14);

        int[] nums3 = {8};
        Assert.equals(minOperations(nums3), 0);

        int[] nums4 = {4881,2593,6819,9256,4135};
        Assert.equals(minOperations(nums4), 7411);
    }

    public static int minOperations(int[] nums) {
        int operationNum = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                continue;
            }
            operationNum += nums[i - 1] - nums[i] + 1;
            nums[i] = nums[i - 1] + 1;
        }
        return operationNum;
    }
}
