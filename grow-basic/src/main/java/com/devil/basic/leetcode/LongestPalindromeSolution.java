package com.devil.basic.leetcode;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * @author Devil
 * @date Created in 2021/7/1 14:19
 */
public class LongestPalindromeSolution {

    /**
     * 中心扩散法
     */
    public static String solutionOne(String s) {
        if (s == null || s.length() < 2) {
            return "";
        }

        int maxLen = 0;
        int maxStart = 0;
        int left;
        int right;
        for (int i = 0; i < s.length(); i++) {
            //　默认是一个很重要
            int len = 1;
            left = i - 1;
            right = i + 1;
            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                left--;
                len++;
            }
            while (right < s.length() && s.charAt(i) == s.charAt(right)) {
                right++;
                len++;
            }
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                len = len + 2;
                left--;
                right++;
            }
            if (len > maxLen) {
                maxLen = len;
                maxStart = left;
            }
        }
        return s.substring(maxStart + 1, maxStart + 1 + maxLen);
    }

    /**
     * 动态规划法
     */
    public static String solutionTwo(String s) {
        if (s == null || s.length() < 2) {
            return "";
        }

        int strLen = s.length();
        //最长回文串的起点
        int maxStart = 0;
        //最长回文串的终点
        int maxEnd = 0;
        //最长回文串的长度
        int maxLen = 1;

        boolean[][] dp = new boolean[strLen][strLen];
        for (int r = 1; r < strLen; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        maxStart = l;
                        maxEnd = r;
                    }
                }
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }

    public static void main(String[] args) {
        System.out.println(solutionOne("vabba"));
        System.out.println(solutionTwo("abccba"));
    }

}
