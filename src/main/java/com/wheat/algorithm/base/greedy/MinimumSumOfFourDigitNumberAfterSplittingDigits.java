package com.wheat.algorithm.base.greedy;

/**
 * @author maij
 * @description: https://leetcode.com/problems/minimum-sum-of-four-digit-number-after-splitting-digits/
 * @date 2023-11-03 17:31
 **/
public class MinimumSumOfFourDigitNumberAfterSplittingDigits {

    public static void main(String[] args) {
        System.out.println(minimumSum(2329));
    }

    
    public static int minimumSum(int num) {
        int[] nums = new int[4];
        for (int i = 0; i < nums.length; i++) {
            int current = num % 10;
            num /= 10;
            int j = i - 1;
            for (; j > -1; j--) {
                if (current < nums[j]) {
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
            }
            nums[j + 1] = current;
        }

        return (nums[0] + nums[1]) * 10 + (nums[2] + nums[3]);
    }
}
