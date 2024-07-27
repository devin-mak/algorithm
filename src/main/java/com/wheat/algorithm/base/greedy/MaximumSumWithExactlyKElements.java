package com.wheat.algorithm.base.greedy;

import cn.hutool.core.lang.Assert;

/**
 * @author maij
 * @description:
 * @date 2023-11-06 11:13
 **/
public class MaximumSumWithExactlyKElements {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5};
        Assert.equals(maximizeSum(nums1, 3), 18);

        int[] nums2 = {5, 5, 5};
        Assert.equals(maximizeSum(nums2, 2), 11);
    }

    public static int maximizeSum(int[] nums, int k) {
        int max = nums[0];
        for (int num : nums) {
            if (max < num) {
                max = num;
            }
        }
        return max * k + (k - 1) * k / 2;
    }
}
