package com.wheat.algorithm.base.sort;

import cn.hutool.core.util.RandomUtil;

import java.util.Arrays;

/**
 * @author maij
 * @description:
 * @date 2024-07-08 13:30
 **/
public class MergeSort {

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
        int m = (l + r) / 2;
        sort(nums, l, m);
        sort(nums, m + 1, r);
        merge(nums, l , m, r);
    }

    public static void merge(int[] nums, int l, int m, int r) {
        int[] temp = new int[r - l + 1];
        int i = l, j = m + 1, k = 0;
        while (i <= m && j <= r) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= m) {
            temp[k++] = nums[i++];
        }

        while (j <= r) {
            temp[k++] = nums[j++];
        }
        for (int n = 0; n <= r - l; n++) {
            nums[l + n] = temp[n];
        }
    }
}
