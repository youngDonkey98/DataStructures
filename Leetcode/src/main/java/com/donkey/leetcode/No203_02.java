package com.donkey.leetcode;

/**
 * @Author zwx
 * @Date 2021/5/17 0:39
 *  使用递归 解决 203. 移除链表元素
 */
public class No203_02 {

    public ListNode removeElements(ListNode head, int val) {

        if (head == null) {
            return null;
        }

        // 删除掉 链表中 包含val的节点
        ListNode res = removeElements(head.next, val);
        // 头节点需要删除
        if (head.val == val) {
            return res;
        } else {
            head.next = res;
            return head;
        }
    }
}
