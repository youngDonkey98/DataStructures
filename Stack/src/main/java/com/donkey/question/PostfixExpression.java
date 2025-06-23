package com.donkey.question;

import java.util.Stack;

/**
 * @author donke
 * @version 1.0
 * @project DataStructures
 * @description 中缀表达式转后缀表达式 (逆波兰表达式)
 * @date 2025/6/23 10:59:47
 */
public class PostfixExpression {

    /**
     * 算法逻辑：
     *  step1：遇到操作数 直接加入后缀表达式
     *  step2：遇到界限符
     *      2.1 遇到 "(" 直接入栈 遇到 ")" 则依次弹出站内运算符并加入到后缀表达式 直到 "(" 为止
     *  step3：遇到运算符 依次弹出栈中优先级高于或等于当前运算符的所有运算符 并且加入到后缀表达式
     *          若遇到 "(" 或者栈空则停止。 之后将当前运算符入栈
     * @param expression
     * @return
     */
    public static String parse(String expression) {
        StringBuilder sb = new StringBuilder();
        if (expression != null && expression.length() > 0) {
            String[] items = expression.split(" ");
            String[] temp = new String[items.length];
            Stack<String> stack = new Stack<>();
            int index = 0;
            for (int i = 0; i < items.length; i++) {
                // 如果是操作数 直接加入后缀表达式
                if (items[i].matches("\\d+")) {
                    temp[index++] = items[i];
                } else if (items[i].equals("(")) {
                    // 如果是左括号 直接入队列
                    stack.push(items[i]);
                } else if (items[i].equals(")")) {
                    // 如果是右括号 则依次弹出栈内运算符并加入到后缀表达式
                    while (!stack.isEmpty() && !stack.peek().equals("(")) {
                        temp[index++] = stack.pop();
                    }
                    if (!stack.isEmpty() && stack.peek().equals("(")) {
                        stack.pop();
                    }
                } else {
                    // 剩下的都是运算符
                    if (stack.isEmpty() || items[i].equals("(")) {
                        // 队列中是空的 直接加入队列
                        stack.push(items[i]);
                    } else {
                        // 不是空的 判断队列中的操作符和当前操作符的优先级
                        if (items[i].equals("*") || items[i].equals("/")) {
                            // 栈顶的优先级高于等于当前操作符 则将栈顶的运算符加入到后缀表达式
                            while (!stack.isEmpty() && !stack.peek().equals("(")) {
                                if (stack.peek().equals("*") || stack.peek().equals("/")) {
                                    temp[index++] = stack.pop();
                                } else {
                                    break;
                                }
                            }
                        } else if (items[i].equals("+") || items[i].equals("-")) {
                            while (!stack.isEmpty() && !stack.peek().equals("(")) {
                                temp[index++] = stack.pop();
                            }
                        }
                        // 最终将当前的运算符入栈
                        stack.push(items[i]);
                    }
                }
            }
            while (!stack.isEmpty() && !stack.peek().equals("(")) {
                temp[index++] = stack.pop();
            }
            for (String s : temp) {
                if (s != null) {
                    sb.append(s).append(" ");
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s1 = parse("1 + 2 * ( 3 + 4 )");
        String s2 = parse("1 + 2 * ( 3 + 4 ) * ( 15 - 7 )");
        String s3 = parse("1 + 2 * ( 3 + 4 ) / 7");
        String s4 = parse("( 1 + 2 ) - ( 3 + 4 ) / 7");
        String s5 = parse("1 - 2 + 2 * 3");
        String s6 = parse("( ( 1 - 2 ) + 2 ) * 3");
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
        System.out.println("s3 = " + s3);
        System.out.println("s4 = " + s4);
        System.out.println("s4 = " + s4);
        System.out.println("s5 = " + s5);
        System.out.println("s6 = " + s6);
    }
}
