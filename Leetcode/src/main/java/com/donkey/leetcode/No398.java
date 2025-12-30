package com.donkey.leetcode;

/**
 * @author donke
 * @version 1.0
 * @project DataStructures
 * @description
 * @date 2025/12/29 15:22:34
 *
 *
            给定两个字符串 s 和 t ，它们只包含小写字母。

            字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。

            请找出在 t 中被添加的字母。
 *
 */
public class No398 {

    public static char findTheDifference(String s, String t) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            cnt[ch - 'a']++;
        }
        for (int i = 0; i < t.length(); ++i) {
            char ch = t.charAt(i);
            cnt[ch - 'a']--;
            if (cnt[ch - 'a'] < 0) {
                return ch;
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "abc";
        char s = findTheDifference(s1, s2);
        System.out.println("s = " + s);
    }
}
