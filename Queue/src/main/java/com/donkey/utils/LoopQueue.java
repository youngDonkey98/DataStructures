package com.donkey.utils;

/**
 * 循环队列
 *  当 front == tail 时 队列为空  （初始时 front 和 tail 指向同一个）
 *  当 （tail + 1） % capacity == front 队列满了 需要扩容 capacity  ====> 扩容时机
 *  浪费 一个 容量
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;   // 存储数据
    private int front;
    private int tail;
    private int size;   // 队列大小

    /**
     * 无参构造
     *  默认初始化容量为 10
     */
    public LoopQueue() {
        this(10);
    }

    /**
     * 设置容量的循环队列
     *  循环队列会浪费一个容量 所以创建的数组 需要比传入的容量大一
     * @param capacity
     */
    public LoopQueue(int capacity) {
        data =(E[]) new Object[capacity + 1];
        // 初始化成员变量
        front = 0;
        tail = 0;
        size = 0;
    }


    /**
     * 入队
     * 当 （tail + 1） % capacity == front 队列满了 需要扩容 capacity  ====> 扩容时机
     * @param e
     */
    @Override
    public void enqueue(E e) {
        if ((tail + 1) % getCapacity() == front) {
            // 扩容
            resize(getCapacity() * 2);
        }

        // 存数据
        data[tail] = e;
        // 维护tail 维护size
        tail = (tail + 1) % data.length;
        size++;
    }

    /**
     * 改变容量
     * @param newCapacity 新容量
     */
    private void resize(int newCapacity) {
        // 扩容动态数组
        E[] newData =(E[]) new Object[newCapacity + 1];

        for (int i = 0; i < size; i++) {
            // 原数据 可能不是在 数组下标为0的时候 是第一个元素
            newData[i] = data[(i + front) % data.length];
        }

        // 循环队列头部归0 尾部为数据大小
        data = newData;
        front = 0;
        tail = size;

    }

    /**
     * 出队
     * @return
     */
    @Override
    public E dequeue() {
        // 1. 判空
        if (isEmpty()) {
            throw new IllegalArgumentException("队列为空");
        }

        // 2. 出队
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length; // 实质 front++
        size--;

        // 3. 判断是否需要缩容
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队列为空");
        }
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("LoopQueue : size = %d ,capacity = %d \n" , size ,getCapacity()));
        res.append("front [");
        for (int i = front; i < tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            //如果不是最后一个元素
            if((i + 1) % data.length != tail){
                res.append(", ");
            }
        }
        res.append("] tail");

        return res.toString();
    }

    public int getCapacity() {
        return data.length - 1;
    }
}
