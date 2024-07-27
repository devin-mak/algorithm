package com.wheat.algorithm.base.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author maij
 * @description:
 * @date 2024-07-19 15:50
 **/
public class DiameterOfBinaryTree {

    private final Map<TreeNode, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(5);

        TreeNode t3 = new TreeNode(2, t1, t2);

        TreeNode t4 = new TreeNode(3);

        TreeNode t5 = new TreeNode(1, t3, t4);

        DiameterOfBinaryTree diameterOfBinaryTree = new DiameterOfBinaryTree();
        int i = diameterOfBinaryTree.diameterOfBinaryTree3(t5);
        System.out.println(i);
    }
    /************* 方案一 **************/
    public int diameterOfBinaryTree1(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int diameter = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.peek() != null) {
            TreeNode node = queue.poll();
            diameter = Math.max(diameter, depth(root.left) + depth(root.right) + 2);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return diameter;
    }

    /************* 方案二 **************/
    public int diameterOfBinaryTree2(TreeNode root) {
        return diameterOfBinaryTree(root, 0);
    }

    public int diameterOfBinaryTree(TreeNode root, int diameter) {
        if (root == null) {
            return diameter;
        }
        diameter = Math.max(diameter, depth(root.left) + depth(root.right) + 2);
        diameter = Math.max(diameter, diameterOfBinaryTree(root.left, 0));
        diameter = Math.max(diameter, diameterOfBinaryTree(root.right, 0));
        return diameter;
    }

    public int depth(TreeNode node) {
        if (node == null) {
            return -1;
        }
        Integer diameter = map.get(node);
        if (diameter != null) {
            return diameter;
        }
        int ld = depth(node.left);
        int rd = depth(node.right);
        diameter = Math.max(ld + 1, rd + 1);
        map.put(node, diameter);
        return diameter;
    }

    /************* 方案三 **************/

    int diameter = 0;

    public int diameterOfBinaryTree3(TreeNode root) {
        depth1(root);
        return diameter;
    }

    public int depth1(TreeNode node) {
        if (node == null) {
            return -1;
        }
        int ld = depth1(node.left);
        int rd = depth1(node.right);
        diameter = Math.max(diameter, ld + rd + 2);
        return Math.max(ld + 1, rd + 1);
    }
}
