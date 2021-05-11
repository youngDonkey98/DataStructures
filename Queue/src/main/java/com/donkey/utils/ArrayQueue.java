package com.donkey.utils;

/**
 * @Author zwx
 * @Date 2021/5/11 10:57
 * @Description
 * @Modified By:
 * @Version:1.0.0
 */
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    // 无参构造
    public ArrayQueue() {
        array = new Array<>();
    }

    // 初始化容量的构造器
    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }

    /**
     * 入队
     * @param e
     */
    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    /**
     * 出队
     * @return
     */
    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    /**
     * 看看队顶（队列中的第一个元素）
     * @return
     */
    @Override
    public E getFront() {
        return array.getFirst();
    }

    /**
     * 队列大小
     * @return
     */
    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder ruslt = new StringBuilder();
        ruslt.append("Queue :");
        ruslt.append("Front [");
        for (int i = 0; i < array.getSize(); i++) {
            ruslt.append(array.get(i));
            //如果不是最后一个元素
            if(i != array.getSize() -1){
                ruslt.append(", ");
            }
        }
        ruslt.append("] tail");

        return ruslt.toString();
    }
}
