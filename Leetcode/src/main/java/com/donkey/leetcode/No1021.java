package com.donkey.leetcode;

import java.util.LinkedList;

/**
 * @Author zwx
 * @Date 2021/5/12 0:07
 * @Description 删除最外侧括号
 * @Modified By:
 * @Version:1.0.0
 * 期望值：
 *  (()()) (())  ---> ()()()
 *  (()()) (()) ((()))  ---> ()() () (())
 *  执行用时：300 ms
 *  内存消耗：38.6 MB
 */
public class No1021 {

    public String removeOuterParentheses(String S) {
        LinkedList<Character> list = new LinkedList<>();

        int top = 0; // 计数器 用于记录栈底的下标
        int num = 0; // 计数器 用于记录左括号的个数
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            list.add(c);

            if ( c == '(') {
                num++;
            }
            if ( c == ')' && i % 2 == 1 && (i + 1 - top) / 2 == num) {
                list.set(i,'0');
                list.set(top,'0');
                top = i + 1;
                num = 0;
                System.out.println("list = " + list);
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != '0') {
                sb.append(list.get(i));
            }
        }
        String s = new String(sb);
        return s;
    }

    public static void main(String[] args) {
        // (()()) (())  ---> ()()()
        // (()()) (()) ((()))  ---> ()() () (())
        String s = new No1021().removeOuterParentheses("(()())(())");
        System.out.println(s);
    }
}
