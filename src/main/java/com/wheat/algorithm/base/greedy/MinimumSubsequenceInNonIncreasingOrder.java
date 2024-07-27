package com.wheat.algorithm.base.greedy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author maij
 * @description:
 * @date 2023-11-09 14:29
 **/
public class MinimumSubsequenceInNonIncreasingOrder {

    public static void main(String[] args) {
        int[] nums1 = {4,3,10,9,8};
        System.out.println(minSubsequence1(nums1));

        int[] nums2 = {4,4,7,6,7};
        System.out.println(minSubsequence1(nums2));

        int[] nums3 = {7,4,2,8,1,7,7,10};
        System.out.println(minSubsequence1(nums3));
    }

    public static List<Integer> minSubsequence(int[] nums) {
        int sum = 0;
        int max = 0;
        for (int num : nums) {
            if (max < num) {
                max = num;
            }
            sum += num;
        }
        int[] array = new int[max + 1];
        for (int num : nums) {
            array[num] += 1;
        }
        List<Integer> result = new LinkedList<>();
        int total = 0;
        for (int i = array.length - 1; i >= 0;) {
            if (array[i] == 0) {
                i--;
                continue;
            }
            total += i;
            result.add(i);
            if ((sum - total) < total) {
                break;
            }
            if (--array[i] < 1) {
                i--;
            }
        }
        return result;
    }

    public static List<Integer> minSubsequence1(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        Arrays.sort(nums);
        int total = 0;
        List<Integer> result = new LinkedList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            total += nums[i];
            result.add(nums[i]);
            if ((sum - total) < total) {
                break;
            }
        }
        return result;
    }
}
