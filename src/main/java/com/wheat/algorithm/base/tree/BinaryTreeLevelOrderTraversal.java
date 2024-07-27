package com.wheat.algorithm.base.tree;

import java.util.*;

/**
 * @author maij
 * @description:
 * @date 2024-07-25 16:08
 **/
public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(15);
        TreeNode t2 = new TreeNode(7);

        TreeNode t3 = new TreeNode(9);

        TreeNode t4 = new TreeNode(20, t1, t2);

        TreeNode t5 = new TreeNode(3, t3, t4);

        BinaryTreeLevelOrderTraversal binaryTreeLevelOrderTraversal = new BinaryTreeLevelOrderTraversal();
        System.out.println(binaryTreeLevelOrderTraversal.levelOrder(t5));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (Objects.isNull(root)) {
            return Collections.emptyList();
        }

        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(root);

        while (deque.size() > 0) {
            List<Integer> items = new ArrayList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = deque.poll();
                items.add(treeNode.val);
                if (treeNode.left != null) {
                    deque.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    deque.add(treeNode.right);
                }
            }
            result.add(items);
        }
        return result;
    }
}
