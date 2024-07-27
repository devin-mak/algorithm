package com.wheat.algorithm.base.dynamicprogramming;

/**
 * @author maij
 * @description:
 * @date 2023-06-14 15:58
 **/
public class Bag01 {

    public static void main(String[] args) {
        Bag01 bag01 = new Bag01();
        int[] ws = {6 , 9 , 14, 11, 34};
        for (int i = 1; i < 50; i++) {
            System.out.println(i + "= " + bag01.cal(ws, i));
        }

    }

    private int cal(int[] ws, int w) {
        boolean[] status = new boolean[w + 1];
        status[0] = true;
        if (ws[0] <= w) {
            status[ws[0]] = true;
        }
        for (int i = 1; i < ws.length; i++) {
            for (int j = w; j >= 0; j--) {
                if (status[j] && j + ws[i] <= w) {
                    status[j + ws[i]] = true;
                }
            }
        }
        for (int i = w; i >= 0; i--) {
            if (status[i]) {
                return i;
            }
        }
        return 0;
    }

//    private int cal(int[] ws, int w) {
//        boolean[][] status = new boolean[ws.length][w + 1];
//        status[0][0] = true;
//        if (ws[0] <= w) {
//            status[0][ws[0]] = true;
//        }
//        for (int i = 1; i < ws.length; i++) {
//            for (int j = 0; j <= w; j++) {
//                if (status[i - 1][j]) {
//                    status[i][j] = true;
//                    if (j + ws[i] <= w) {
//                        status[i][j + ws[i]] = true;
//                    }
//                }
//            }
//        }
//        for (int i = w; i >= 0; i--) {
//            if (status[ws.length - 1][i]) {
//                return i;
//            }
//        }
//        return 0;
//    }
}
