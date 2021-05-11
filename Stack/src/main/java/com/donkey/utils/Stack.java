package com.donkey.utils;

public interface Stack<E> {


    int getSize();

    boolean isEnpty();

    // 向队列中添加元素
    void push(E e);

    // 出栈
    E pop();

    // 查看栈顶元素
    E peek();
}
