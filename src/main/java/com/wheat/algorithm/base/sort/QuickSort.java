package com.wheat.algorithm.base.sort;

import cn.hutool.core.util.RandomUtil;

import java.util.Arrays;

/**
 * @author maij
 * @description:
 * @date 2024-07-08 13:47
 **/
public class QuickSort {

    public static void main(String[] args) {
        int[] nums = RandomUtil.randomInts(10);
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    public static void sort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = p(nums, l , r);
        sort(nums, l, p - 1);
        sort(nums, p + 1, r);
    }

    public static int p(int[] nums, int l, int r) {
        int i = l - 1, j = l;
        for (; j < r; j++) {
            if (nums[j] > nums[r]) {
                continue;
            }
            swap(nums, ++i, j);
        }
        swap(nums, ++i, r);
        return i;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
