package com.donkey.utils;

/**
 * @Author zwx
 * @Date 2021/5/16 14:14
 * @Description
 * @Modified By:
 * @Version:1.0.0
 */
public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < 5; i++) {
            list.addFirst(i);
        }
        System.out.println("list = " + list);

        list.add(2,666);
        System.out.println("list + 666 = " + list);

        list.remove(2);
        System.out.println("list = " + list);

        list.removeFirst();
        System.out.println("list = " + list);

        list.removeLast();
        System.out.println("list = " + list);
    }
}
