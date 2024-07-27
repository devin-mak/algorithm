package com.wheat.algorithm.base.sort;

import cn.hutool.core.util.RandomUtil;

import java.util.Arrays;
import java.util.Random;

/**
 * @author maij
 * @description:
 * @date 2024-07-08 10:40
 **/
public class insertionSort {

    public static void main(String[] args) {
        int[] nums = RandomUtil.randomInts(1);
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > n) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = n;
        }
    }
}
