package com.wheat.algorithm.base.lookback;

import java.util.List;
import java.util.Random;

/**
 * @author maij
 * @description:
 * @date 2023-06-27 11:48
 **/
public class Shopping {

    private static final int FULL_DEDUCTION = 200;

    private int max = Integer.MAX_VALUE;

    private List<Integer> resultGoods;

    public static void main(String[] args) {
        Shopping shopping = new Shopping();
        int[] goods = new int[20];
        Random random = new Random();
        for (int i = 0; i < goods.length; i++) {
            goods[i] = random.nextInt(1000);
        }
        boolean[] result = new boolean[goods.length];
        System.out.println(shopping.max);
    }

    private void cal(int[] goods, int sum, int i) {
        if (sum >= FULL_DEDUCTION) {
            max = Math.min(sum, max);
            return;
        }

        if (i == goods.length ) {
            return;
        }
        for (; i < goods.length; i++) {
            cal(goods, sum, i + 1);
            cal(goods, goods[i] + sum, i + 1);
        }
    }
}
