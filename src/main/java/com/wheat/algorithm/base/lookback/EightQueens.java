package com.wheat.algorithm.base.lookback;

import java.util.ArrayList;
import java.util.List;

/**
 * 八皇后
 * @author mj
 * @description:
 * @date 2023-06-05 18:06
 **/
public class EightQueens {

    private List<Result> results = new ArrayList<Result>();

    public static void main(String[] args) {
        EightQueens eightQueens = new EightQueens();
        List<Result> r = eightQueens.cal();
        for (Result result : r) {
            result.print();
        }
        System.out.println("一共有" + r.size() + "可能");
    }

    private List<Result> cal() {
        cal(0, new int[8]);
        return results;
    }

    private void cal(int row, int[] result) {
        if (row == result.length) {
            results.add(new Result(result));
            return;
        }
        for (int column = 0; column < result.length; column++) {
            if (check(result, row, column)) {
                result[row] = column;
                cal(row + 1, result);
            }
        }
    }

    /**
     * row： y轴； column: x轴
     * @param result
     * @param row
     * @param column
     * @return
     */
    private boolean check(int[] result, int row, int column) {
        for (int i = 1; i <= row; i++) {
            int y = row - i;
            if (result[y] == column) {
                return false;
            }
            if (result[y] == column - i) {
                return false;
            }
            if (result[y] == column + i) {
                return false;
            }
        }
        return true;
    }

    private static class Result {

        int[] chessPieces = new int[8];

        Result(int[] result) {
            for (int i = 0; i < result.length; i++) {
                chessPieces[i] = result[i];
            }
        }

        public void print() {
            for (int i = 0; i < chessPieces.length; i++) {
                for (int j = 0; j < chessPieces.length; j++) {
                    if (chessPieces[i] == j) {
                        System.out.print(1 + " ");
                    } else {
                        System.out.print(0 + " ");
                    }
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
