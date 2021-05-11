package com.donkey.utils;

public class Main {

    public static void main(String[] args) {

        Array arr = new Array(20);
        for (int i = 0; i < 12; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);

        arr.add(2,300);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);

        System.out.println(" ---------------------- ");
        Integer[] arr_i = {1,2,3};
        Array arr1 = new Array<>(arr_i);
        System.out.println(arr1);

        arr.addFirst(300);
        System.out.println(arr);
        arr.remove(1);
        System.out.println("arr = " + arr);
        System.out.println(arr.find(300));
        System.out.println(arr.findAll(300));

    }
}
