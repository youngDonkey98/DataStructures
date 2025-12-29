package com.donkey.leetcode;

/**
 * @author donke
 * @version 1.0
 * @project DataStructures
 * @description
 * @date 2025/12/29 15:22:34
 *
 *
 * 给你两个字符串 word1 和 word2 。
 * 请你从 word1 开始，通过交替添加字母来合并字符串。
 * 如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。
 *
 * 返回 合并后的字符串 。
 *
 */
public class No1786 {

    public static String mergeAlternately(String word1, String word2) {
        // 二路归并
        StringBuffer res = new StringBuffer();
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();
        for (int i = 0; i < c1.length; i++) {
            res.append(c1[i]);
            // word1到最后一个字符了
            if (c1.length - 1 == i) {
                // 如果word2比word1长 将长的部分直接补齐
                if (c2.length > i) {
                    res.append(word2.substring(i));
                }
            } else {
                // word1没到最后一个字符
                // 判断word2是否是最后一个字符
                if (c2.length == i) {
                    res.append(word1.substring(i + 1));
                    return res.toString();
                } else {
                    // word2不是最后一个字符
                    res.append(c2[i]);
                }
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "pqr";
        String s = mergeAlternately(s1, s2);
        System.out.println("s = " + s);
    }
}
