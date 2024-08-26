package com.wheat.algorithm.base.tree;

import com.wheat.algorithm.base.utils.TreeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author maij
 * @description:
 * @date 2024-07-25 17:45
 **/
public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        Integer[] nums = {120,70,140,50,100,130,160,20,55,75,110,119,135,150,200};
        TreeNode treeNode = TreeUtil.buildTree(nums);
        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
        System.out.println(validateBinarySearchTree.isValidBST1(treeNode));
    }

    public boolean isValidBST(TreeNode root) {
        List<Integer> array = new ArrayList<>();
        inOrder(root, array);
        for (int i = 1; i < array.size(); i++) {
            if (array.get(i - 1) >= array.get(i)) {
                return false;
            }
        }
        return true;
    }

    public void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    public boolean isValidBST1(TreeNode root) {
        if (root == null) {
            return true;
        }
        Integer left = getVal(root.left, true);
        Integer right = getVal(root.right, false);
        return (left == null || left < root.val) && (right == null || right > root.val);
    }

    public Integer getVal(TreeNode root, boolean left) {
        if (root == null) {
            return null;
        }
        Integer l = getVal(root.left, true);
        Integer r = getVal(root.right, false);
        if ((l != null && l >= root.val) || (r != null && r <= root.val)) {
            return left ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return left ? (r == null ? root.val : r) : (l == null ? root.val : l);
    }
}
