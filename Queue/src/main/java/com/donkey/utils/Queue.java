package com.donkey.utils;

/**
 * @Author zwx
 * @Date 2021/5/11 10:51
 * @Description
 * @Modified By:
 * @Version:1.0.0
 */
public interface Queue<E> {

    // 入队
    void enqueue(E e);

    // 出队
    E dequeue();

    // 查看队首的元素
    E getFront();

    int getSize();

    boolean isEmpty();

}
