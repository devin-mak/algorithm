package com.wheat.algorithm.base.dynamicprogramming;

/**
 * @author maij
 * @description:
 * @date 2023-06-27 17:08
 **/
public class LevenshteinDistance {

    private int cal(String a, String b) {
        int[][] state = new int[a.length()][b.length()];

        for (int i = 0; i < a.length(); ) {
            for (int j = 0; j < b.length(); ) {
                if (a.charAt(i) == b.charAt(j)) {

                }
            }
        }
        return 0;
    }
}
