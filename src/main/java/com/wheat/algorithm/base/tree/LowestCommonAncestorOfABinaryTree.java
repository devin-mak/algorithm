package com.wheat.algorithm.base.tree;

import java.util.*;

/**
 * @author maij
 * @description:
 * @date 2024-07-21 23:13
 **/
public class LowestCommonAncestorOfABinaryTree {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(7);
        TreeNode t2 = new TreeNode(4);

        TreeNode t3 = new TreeNode(6);

        TreeNode t4 = new TreeNode(2, t1, t2);

        TreeNode t5 = new TreeNode(0);

        TreeNode t6 = new TreeNode(8);

        TreeNode t7 = new TreeNode(5, t3, t4);

        TreeNode t8 = new TreeNode(1, t5, t6);

        TreeNode t9 = new TreeNode(3, t7, t8);

        LowestCommonAncestorOfABinaryTree tree = new LowestCommonAncestorOfABinaryTree();
        System.out.println(tree.lowestCommonAncestor(t9, t7, t2));
    }


    /******* 思路一 **********/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p ,q);
        return ans;
    }
    TreeNode ans;
    public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean l = dfs(root.left, p, q);
        boolean r = dfs(root.right, p, q);
        if ((l && r) || ((root == p || root == q) && (l || r))) {
            ans = root;
        }
        return l || r || root == p || root == q;
    }


    /******* 思路一 **********/
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pResult = search(root, p);
        List<TreeNode> qResult = search(root, q);
        if (pResult == null || qResult == null) {
            return null;
        }
        Set<TreeNode> set = new HashSet<>(qResult);
        for (int i = pResult.size() - 1; i >= 0; i--) {
            TreeNode treeNode = pResult.get(i);
            if (set.contains(treeNode)) {
                return treeNode;
            }
        }
        return null;
    }

    public List<TreeNode> search(TreeNode root, TreeNode p) {
        result = null;
        search = false;
        search(root, p, new LinkedList<>());
        if (!search) {
            return null;
        }
        return new ArrayList<>(result);
    }

    ArrayList<TreeNode> result;
    boolean search;
    public void search(TreeNode root, TreeNode p, List<TreeNode> path) {
        if (root == null || search) {
            return;
        }
        if (root == p) {
            path.add(p);
            result = new ArrayList<>(path);
            search = true;
            return;
        }
        path.add(root);
        search(root.left, p, path);
        search(root.right, p, path);
        path.remove(path.size() - 1);
    }
}
