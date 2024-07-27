package com.wheat.algorithm.base.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author maij
 * @description:
 * @date 2024-07-19 11:47
 **/
public class SymmetricTree {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(4);

        TreeNode t3 = new TreeNode(2, t1, t2);

        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(3);

        TreeNode t7 = new TreeNode(2, t5, t6);

        TreeNode t8 = new TreeNode(1, t3, t7);
        SymmetricTree symmetricTree = new SymmetricTree();
        System.out.println(symmetricTree.isSymmetric(t8));
    }

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode l, TreeNode r) {
        if (l == null && r == null) {
            return true;
        }

        if (l == null || r == null) {
            return false;
        }

        return l.val == r.val && isSymmetric(l.left, r.right) && isSymmetric(l.right, r.left);
    }

    public boolean isSymmetric1(TreeNode root) {
        Queue<TreeNode> left = new LinkedList<>();
        Queue<TreeNode> right = new LinkedList<>();
        left.add(root.left);
        right.add(root.right);
        while (left.size() > 0 || right.size() > 0) {
            if (left.size() != right.size()) {
                return false;
            }
            TreeNode l = left.poll();
            TreeNode r = right.poll();
            if (l == null && r == null) {
                continue;
            }

            if (l == null || r == null) {
                return false;
            }

            if (l.val != r.val) {
                return false;
            }
            left.add(l.left);
            left.add(l.right);

            right.add(r.right);
            right.add(r.left);
        }
        return true;
    }
}
