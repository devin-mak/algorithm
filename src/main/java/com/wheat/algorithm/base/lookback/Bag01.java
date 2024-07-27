package com.wheat.algorithm.base.lookback;

/**
 * 0-1 背包
 * @author mj
 * @description:
 * @date 2023-06-07 12:24
 **/
public class Bag01 {

    private int[] ws = {6 , 9 , 14, 11, 34};

    private int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Bag01 bag01 = new Bag01();
        System.out.println(bag01.cal(33));
    }

    private int cal(int w) {
        cal(w, 0, 0);
        return max;
    }

    private void cal(int w, int n, int total) {
        if (w < 0) {
            return;
        }
        if (w == 0 || n == ws.length) {
            max = Math.max(total, max);
            return;
        }
        cal(w, n + 1, total);
        cal(w - ws[n], n + 1, total + ws[n]);
    }
}
