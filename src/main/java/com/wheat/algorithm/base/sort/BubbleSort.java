package com.wheat.algorithm.base.sort;

import cn.hutool.core.util.RandomUtil;

import java.util.Arrays;

/**
 * @author maij
 * @description:
 * @date 2024-07-08 11:18
 **/
public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = RandomUtil.randomInts(20);
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean flag = true;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                    flag = false;
                }
            }
            if (flag) {
                return;
            }
        }
    }
}
