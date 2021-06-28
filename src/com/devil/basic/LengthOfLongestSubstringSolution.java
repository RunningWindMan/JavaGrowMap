package com.devil.basic;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * @author Devil
 * @date Created in 2021/6/28 19:25
 */
public class LengthOfLongestSubstringSolution {

    public static int solutionOne(String s) {
        int n = s.length(), result = 0;
        Map<Character, Integer> subStringMap = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char c = s.charAt(end);
            if (subStringMap.containsKey(c)) {
                start = Math.max(subStringMap.get(c), start);
            }
            result = Math.max(result, end - start + 1);
            subStringMap.put(c, end + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(solutionOne("abcabcbb"));
    }

}
