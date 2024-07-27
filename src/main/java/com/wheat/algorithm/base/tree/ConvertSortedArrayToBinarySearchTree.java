package com.wheat.algorithm.base.tree;

/**
 * @author maij
 * @description:
 * @date 2024-07-25 16:59
 **/
public class ConvertSortedArrayToBinarySearchTree {

    public static void main(String[] args) {
        int[] nums = {120,70,140,50,100,130,160,20,55,75,110,119,135,150,200};
        ConvertSortedArrayToBinarySearchTree tree = new ConvertSortedArrayToBinarySearchTree();
        System.out.println(tree.sortedArrayToBST(nums));
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int i, int j) {
        if (i > j) {
            return null;
        }
        int m = (i + j) / 2;
        TreeNode node = new TreeNode(nums[m]);
        node.left = sortedArrayToBST(nums, i, m - 1);
        node.right = sortedArrayToBST(nums, m + 1, j);
        return node;
    }
}
