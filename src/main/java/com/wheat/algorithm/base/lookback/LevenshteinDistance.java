package com.wheat.algorithm.base.lookback;

/**
 * @author maij
 * @description:
 * @date 2023-06-16 11:45
 **/
public class LevenshteinDistance {

    private String a;

    private String b;

    private int distance = Integer.MAX_VALUE;

    public static void main(String[] args) {
        LevenshteinDistance levenshteinDistance = new LevenshteinDistance();
        levenshteinDistance.a = "mitcmua";
        levenshteinDistance.b = "mtacnu";
        levenshteinDistance.cal(0, 0, 0);
        System.out.println(levenshteinDistance.distance);
    }

    void cal(int n, int m, int d) {
        if (n == a.length() || m == b.length()) {
            d += (a.length() - n) + (b.length() - m);
            distance = Math.min(d, distance);
            return;
        }
        if (a.charAt(n) == b.charAt(m)) {
            cal(n + 1, m + 1, d);
        } else {
                cal(n + 1, m, d + 1);
                cal(n, m + 1, d + 1);
                cal(n + 1, m + 1, d + 1);
        }
    }
}
