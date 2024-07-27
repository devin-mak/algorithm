package com.wheat.algorithm.base.utils;

import com.wheat.algorithm.base.tree.TreeNode;

/**
 * @author maij
 * @description:
 * @date 2024-07-26 10:06
 **/
public class TreeUtil {

    public static TreeNode buildTree(int[] nums) {
        return buildTree(nums, 0);
    }

    private static TreeNode buildTree(int[] nums, int i) {
        if (i >= nums.length) {
            return null;
        }
        TreeNode node = new TreeNode(nums[i]);
        node.left = buildTree(nums, i * 2 + 1);
        node.right = buildTree(nums, i * 2 + 2);
        return node;
    }
}
