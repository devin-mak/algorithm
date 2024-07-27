package com.wheat.algorithm.base.matrix;

import com.wheat.algorithm.base.tree.TreeNode;

/**
 * @author maij
 * @description:
 * @date 2024-07-06 18:01
 **/
public class NumberOfIslands {

    public static void main(String[] args) {
        char[][] grid = new char[4][5];
        grid[0] = new char[]{'1', '1', '1'};
        grid[1] = new char[]{'0', '1', '0'};
        grid[2] = new char[]{'1', '1', '1'};
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        System.out.println(numberOfIslands.numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }
                dfs(grid, i, j);
                num++;
            }
        }
        return num;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length) {
            return;
        }

        if (j < 0 || j >= grid[i].length) {
            return;
        }
        if (grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}
