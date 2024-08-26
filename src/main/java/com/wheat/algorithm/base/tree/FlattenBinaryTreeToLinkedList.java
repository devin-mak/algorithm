package com.wheat.algorithm.base.tree;

import com.wheat.algorithm.base.utils.TreeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author maij
 * @description:
 * @date 2024-08-01 11:38
 **/
public class FlattenBinaryTreeToLinkedList {

    public static void main(String[] args) {
        Integer[] nums = {1, 2, 5, 3, 4, null, 6};
        TreeNode treeNode = TreeUtil.buildTree(nums);
        FlattenBinaryTreeToLinkedList flattenBinaryTreeToLinkedList = new FlattenBinaryTreeToLinkedList();
        flattenBinaryTreeToLinkedList.flatten(treeNode);
    }

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        List<TreeNode> list = new ArrayList<>();
        preOrder(root, list);
        TreeNode node = root;
        for (int i = 1; i < list.size(); i++) {
            node.left = null;
            node.right = list.get(i);
            node = list.get(i);
        }
    }

    public void preOrder(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        list.add(root);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }
}
