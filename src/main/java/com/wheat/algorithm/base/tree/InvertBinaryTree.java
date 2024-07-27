package com.wheat.algorithm.base.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author maij
 * @description:
 * @date 2024-07-18 17:27
 **/
public class InvertBinaryTree {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t3 = new TreeNode(3);

        TreeNode t2 = new TreeNode(2, t1, t3);

        TreeNode t6 = new TreeNode(6);
        TreeNode t9 = new TreeNode(9);

        TreeNode t7 = new TreeNode(7, t6, t9);

        TreeNode t4 = new TreeNode(4, t2, t7);

        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
        TreeNode treeNode = invertBinaryTree.invertTree(t4);
        System.out.println(treeNode);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode l = root.left;
        root.left = root.right;
        root.right = l;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> current = new LinkedList<>();
        Deque<TreeNode> other = new LinkedList<>();
        current.push(root);
        other.push(root.left);
        other.push(root.right);
        while (!other.isEmpty()) {
            while (other.peek() != null) {
                TreeNode o = other.poll();
                TreeNode c = current.poll();

            }
            Deque<TreeNode> temp = current;
            current = other;
            other = temp;
        }
        return root;
    }
}
