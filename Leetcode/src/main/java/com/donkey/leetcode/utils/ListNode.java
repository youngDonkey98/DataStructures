package com.donkey.leetcode.utils;

/**
 * @Author zwx
 * @Date 2021/5/16 22:42
 *
 */
public class ListNode {

    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    // 传入一个数组 创建一个链表 方便调试
    public ListNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("数组传入不合法");
        }
        this.val = arr[0];
        ListNode prev = this;
        for (int i = 0; i < arr.length; i++) {
            prev.next = new ListNode(arr[i]);
            prev = prev.next;
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        ListNode prev = this;
        while(prev != null) {
            sb.append(prev.val + " -> ");
            prev = prev.next;
        }
        sb.append("NULL");
        return sb.toString();
    }

}
