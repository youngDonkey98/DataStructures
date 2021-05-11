package com.donkey.leetcode;

import java.util.Stack;

/**
 * @Author zwx
 * @Date 2021/5/10 23:51
 * @Description 155. 最小栈
 * @Modified By:
 * @Version:1.0.0
 */
public class No155 {
    /**
     * 最小栈 两个栈 一个栈存所有的值 一个栈存最小的值
     */

    private Stack<Integer> stack;
    private Stack<Integer> stack_min;

    public No155() {
        stack = new Stack<Integer>();
        stack_min = new Stack<Integer>();
    }

    public void push(int val) {
        if (stack_min.isEmpty() || stack_min.peek() >= val) {
            stack_min.push(val);
        }
        stack.push(val);
    }

    public void pop() {
        // 如果全值栈中移除的 等于 最小栈中的值 那么最小栈中的值也移除 否者不移除最小栈的栈顶
        if (stack.peek().equals(stack_min.peek())) {
            stack_min.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return stack_min.peek();
    }

    public static void main(String[] args) {
        No155 minStack = new No155();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        int min = minStack.getMin();
        System.out.println("min = " + min);
    }
}
