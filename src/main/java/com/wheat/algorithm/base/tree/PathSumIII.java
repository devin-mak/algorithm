package com.wheat.algorithm.base.tree;

import com.wheat.algorithm.base.utils.TreeUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author maij
 * @description:
 * @date 2024-08-04 11:25
 **/
public class PathSumIII {

    public static void main(String[] args) {
        Integer[] nums = {10, 5, -3, 3, 2, null, 11, 3, -2, null, 1};
        TreeNode treeNode = TreeUtil.buildTree(nums);
        PathSumIII pathSumIII = new PathSumIII();
        System.out.println(pathSumIII.pathSum2(treeNode, 8));
    }

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int total = searchSubTree(root, targetSum);
        total += pathSum(root.left, targetSum);
        total += pathSum(root.right, targetSum);
        return total;
    }

    private int searchSubTree(TreeNode root, long targetSum) {
        int total = 0;
        if (root == null) {
            return 0;
        }
        if (root.val == targetSum) {
            total += 1;
        }

        total += searchSubTree(root.left, targetSum - root.val);
        total += searchSubTree(root.right, targetSum - root.val);
        return total;
    }

    public int pathSum2(TreeNode root, int targetSum) {
        Map<Long, Integer> prefix = new HashMap<>();
        prefix.put(0L, 1);
        return pathSum(root, prefix, 0, targetSum);
    }

    private int pathSum(TreeNode root, Map<Long, Integer> prefix, long current, long targetSum) {
        if (root == null) {
            return 0;
        }
        current += root.val;
        int total = prefix.getOrDefault(current - targetSum, 0);
        prefix.put(current, prefix.getOrDefault(current, 0) + 1);
        total += pathSum(root.left, prefix, current, targetSum);
        total += pathSum(root.right, prefix, current, targetSum);
        prefix.put(current, prefix.getOrDefault(current, 0) - 1);
        return total;
    }
}
