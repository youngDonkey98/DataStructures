package com.donkey.leetcode;

/**
 * @Author zwx
 * @Date 2021/5/12 20:27
 * @Description
 * @Modified By:
 * @Version:1.0.0
 */
public class No1021_01 {
    public String removeOuterParentheses(String S) {
        StringBuffer sb = new StringBuffer();
        int count = 0;
        for (char c : S.toCharArray()) {
            if (c == ')') {
                --count;
            }
            if (count >= 1) {
                sb.append(c);
            }
            if (c == '(') {
                ++count;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // (()()) (())  ---> ()()()
        // (()()) (()) ((()))  ---> ()() () (())
        String s = new No1021_01().removeOuterParentheses("(()())(())");
        System.out.println(s);
    }
}
