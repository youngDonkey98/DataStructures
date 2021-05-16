package com.donkey.utils;

/**
 * @Author zwx
 * @Date 2021/5/16 14:52
 * @Description
 * @Modified By:
 * @Version:1.0.0
 */
public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> list;

    public LinkedListStack() {
        list = new LinkedList();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // 链表头是栈顶
    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Stack top:");
        sb.append(list);
        return sb.toString();
    }
}
