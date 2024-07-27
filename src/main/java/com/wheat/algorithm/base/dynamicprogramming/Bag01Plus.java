package com.wheat.algorithm.base.dynamicprogramming;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;

/**
 * @author maij
 * @description:
 * @date 2023-06-15 16:52
 **/
public class Bag01Plus {

    public static void main(String[] args) {
        Item[] items = new Item[5];
        items[0] = new Item(2, 3);
        items[1] = new Item(2, 4);
        items[2] = new Item(4, 8);
        items[3] = new Item(6, 9);
        items[4] = new Item(3, 6);
        Bag01Plus bag01Plus = new Bag01Plus();
        System.out.println(bag01Plus.cal(items, 15));
    }

    private int cal(Item[] ws, int w) {
        int[] status = new int[w + 1];
        Arrays.fill(status, -1);
        status[0] = 0;
        if (ws[0].weight <= w) {
            status[ws[0].weight] = ws[0].price;
        }
        for (int i = 1; i < ws.length; i++) {
            for (int j = w; j >= 0; j--) {
                if (status[j] > -1 && j + ws[i].weight <= w) {
                    status[j + ws[i].weight] = status[j] + ws[i].price;
                }
            }
        }
        int max = 0;
        for (int i = w; i >= 0; i--) {
            max = Math.max(status[i], max);
        }
        return max;
    }

    @Data
    @AllArgsConstructor
    private static class Item {

        private int weight;

        private int price;

    }
}
