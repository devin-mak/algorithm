package com.wheat.algorithm.base.sort;

import cn.hutool.core.util.RandomUtil;

import java.util.Arrays;

/**
 * @author maij
 * @description:
 * @date 2024-07-08 12:07
 **/
public class SelectionSort {

    public static void main(String[] args) {
        int[] nums = RandomUtil.randomInts(10);
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
            }
            int temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;
        }
    }
}
