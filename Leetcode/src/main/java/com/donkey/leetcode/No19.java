package com.donkey.leetcode;


/**
 * @Author zwx
 * @Date 2021/5/16 0:12
 * @Description 19. 删除链表的倒数第 N 个结点
 *
 *  超时
 */
public class No19 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 获得头节点
        ListNode prev = head;
        // 遍历出链表长度
        int count = 0;

        while (prev.next != null) {
            count++;
        }

        if (count == 0 && n == 1) {
            return new ListNode();
        }
        // 找到删除节点的前一个节点
        for (int i = 0; i < n - count -1; i++) {
            prev = prev.next;
        }
        prev.next = prev.next.next;
        return prev;
    }

}
