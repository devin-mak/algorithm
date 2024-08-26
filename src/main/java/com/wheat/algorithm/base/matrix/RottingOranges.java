package com.wheat.algorithm.base.matrix;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author maij
 * @description:
 * @date 2024-08-07 14:22
 **/
public class RottingOranges {

    public static void main(String[] args) {
        int[][] grid = {{1}, {2}};
        RottingOranges rottingOranges = new RottingOranges();
        System.out.println(rottingOranges.orangesRotting(grid));
    }

    public int orangesRotting(int[][] grid) {
        int sum = 0;
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Point(i, j));
                }

                if (grid[i][j] == 1) {
                    sum++;
                }
            }
        }

        int count = queue.size() > 0 ? -1 : 0;
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point p = queue.poll();
                int x = p.x;
                int y = p.y;
                if (addToQueueIfNeed(grid, x - 1, y, queue)) {
                    sum--;
                }
                if (addToQueueIfNeed(grid, x + 1, y, queue)) {
                    sum--;
                }
                if (addToQueueIfNeed(grid, x, y - 1, queue)) {
                    sum--;
                }
                if (addToQueueIfNeed(grid, x, y + 1, queue)) {
                    sum--;
                }
            }
            count++;
        }

        return sum > 0 ? -1 : count;
    }

    private boolean addToQueueIfNeed(int[][] grid, int x, int y, Queue<Point> queue) {
        if (!needRotting(grid, x, y)) {
            return false;
        }
        grid[x][y] = 2;
        queue.add(new Point(x, y));
        return true;
    }

    private boolean needRotting(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length) {
            return false;
        }

        if (y < 0 || y >= grid[x].length) {
            return false;
        }
        return grid[x][y] == 1;
    }

    private static class Point {
        int x;

        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

}
