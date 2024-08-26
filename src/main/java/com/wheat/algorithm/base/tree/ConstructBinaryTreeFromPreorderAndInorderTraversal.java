package com.wheat.algorithm.base.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author maij
 * @description:
 * @date 2024-08-01 16:27
 **/
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {



    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, 0, map);
    }

    public TreeNode buildTree(int[] preorder, int pl, int pr, int il, Map<Integer, Integer> map) {
        if (pl > pr) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pl]);
        Integer iRoot = map.get(preorder[pl]);
        int leftSubTreeSize = iRoot - il;
        root.left = buildTree(preorder, pl + 1, pl + leftSubTreeSize, il, map);
        root.right = buildTree(preorder, pl + leftSubTreeSize + 1, pr, iRoot + 1, map);
        return root;
    }
}
