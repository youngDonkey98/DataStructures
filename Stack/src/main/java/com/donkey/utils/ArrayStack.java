package com.donkey.utils;

import com.donkey.utils.Stack;

/**
 *  基于 自定义 动态数组实现的 队列
 */
public class ArrayStack<E> implements Stack<E> {

    // 组合复用动态数组
    Array<E> array;

    // 无参构造
    public ArrayStack(){
        array = new Array<>();
    }

    // 初始化容量的构造器
    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    // 查看Stack栈中的容量大小
    public int getCapacity() {
        return array.getCapacity();
    }


    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEnpty() {
        return array.isEmpty();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removerLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }
}
