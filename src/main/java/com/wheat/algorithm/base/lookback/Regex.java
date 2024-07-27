package com.wheat.algorithm.base.lookback;

/**
 * @author maij
 * @description:
 * @date 2023-06-13 01:05
 **/
public class Regex {

    public static final char ASTERISK = '*';
    public static final char QUESTION_MARK = '?';

    private boolean result = false;

    public static void main(String[] args) {
        Regex regex = new Regex();
        regex.match("a*l*s?d?k", "aasdklfasndlk", 0 , 0);
        System.out.println(regex.result);
    }

    /**
     * * 匹配任意多个字符，？ 匹配 0 或 1 个字符
     * @param regex
     * @param s
     * @param n
     * @param m
     */
    private void match(String regex, String s, int n, int m) {
        if (result) {
            return;
        }
        if (n == regex.length()) {
            if (m == s.length()) {
                result = true;
            }
            return;
        }
        if (regex.charAt(n) == ASTERISK) {
            for (int i = m; i < s.length(); i++) {
                // 匹配剩下的 0 到所有个字符
                match(regex, s, n + 1, i);
            }
        } else if (regex.charAt(n) == QUESTION_MARK) {
            // 匹配 0 个字符
            match(regex, s, n + 1, m);
            // 匹配 1 个字符
            match(regex, s, n + 1, m + 1);
        } else if (m < s.length() && regex.charAt(n) == s.charAt(m)) {
            // 匹配 1 个字符
            match(regex, s, n + 1, m + 1);
        }
    }
}
