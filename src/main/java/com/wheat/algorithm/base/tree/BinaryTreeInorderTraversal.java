package com.wheat.algorithm.base.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author maij
 * @description:
 * @date 2024-07-18 16:12
 **/
public class BinaryTreeInorderTraversal {



    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }

    public void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }
}
