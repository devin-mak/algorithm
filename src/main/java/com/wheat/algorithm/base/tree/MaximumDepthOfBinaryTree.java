package com.wheat.algorithm.base.tree;

import java.util.*;

/**
 * @author maij
 * @description:
 * @date 2024-07-18 16:21
 **/
public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
//        TreeNode t7 = new TreeNode(7);
//        TreeNode t15 = new TreeNode(15);
//
//        TreeNode t20 = new TreeNode(20, t15, t7);
//
//        TreeNode t9 = new TreeNode(9);
//
//        TreeNode t3 = new TreeNode(3, t9, t20);

        TreeNode t2 = new TreeNode(2);

        TreeNode t1 = new TreeNode(1, null, t2);

        MaximumDepthOfBinaryTree maximumDepthOfBinaryTree = new MaximumDepthOfBinaryTree();
        System.out.println(maximumDepthOfBinaryTree.depth(t1));
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> current = new LinkedList<>();
        Deque<TreeNode> other = new LinkedList<>();
        current.push(root);
        int i = 0;
        while (!current.isEmpty()) {
            i++;
            while (current.peek() != null) {
                TreeNode poll = current.poll();
                if (poll.left != null) {
                    other.push(poll.left);
                }
                if (poll.right != null) {
                    other.push(poll.right);
                }
            }
            Deque<TreeNode> temp = current;
            current = other;
            other = temp;
        }
        return i;
    }

    public int depth(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }

        int ld = depth(root.left, depth + 1);
        int rd = depth(root.right, depth + 1);
        return Math.max(ld, rd);
    }
}
