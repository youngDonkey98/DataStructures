package com.donkey.leetcode;

import java.util.Stack;

/**
 * @Author zwx
 * @Date 2021/5/10 22:42
 * @Description  20. 有效的括号
 * @Modified By:
 * @Version:1.0.0
 */
public class No20 {

    /**
     * 如果是 '{','[','(' 添加到stack中
     * 如果不是 出栈 判断stack顶端 和 现在这个括号是否是成对的
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character top = stack.pop();
                if (c == '}' && top != '{') {
                    return false;
                }
                if (c == ']' && top != '[') {
                    return false;
                }
                if (c == ')' && top != '(') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
