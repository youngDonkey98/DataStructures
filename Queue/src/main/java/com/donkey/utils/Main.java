package com.donkey.utils;

/**
 * @Author zwx
 * @Date 2021/5/11 14:12
 * @Description
 * @Modified By:
 * @Version:1.0.0
 */
public class Main {

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            // queue.enqueue(i);
            loopQueue.enqueue(i);
            // System.out.println(queue);
            System.out.println(loopQueue);

            if (i % 3 == 2) {
                loopQueue.dequeue();
                // queue.dequeue();
                System.out.println(loopQueue);
                // System.out.println(queue);
            }
        }
    }
}
