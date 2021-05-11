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
        for (int i = 1; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 4 == 0) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
