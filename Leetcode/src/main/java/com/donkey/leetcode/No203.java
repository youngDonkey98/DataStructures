package com.donkey.leetcode;

/**
 * @Author zwx
 * @Date 2021/5/16 18:07
 * @Description 203. 移除链表元素
 *      例子：
 *          1 -- > 2  --> 6 --> 3 --> 4 --> 5 --> 6
 *          移除 6
 *          1 -- > 2  --> 3 --> 4 --> 5
 *
 *      执行时间：1ms
 *      内存消耗：39.2MB
 */
public class No203 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        // 移除 需要找到需要移除的前一个节点
        // 不使用虚拟头节点
        // 如果 第一个节点 就是需要删除的
        while (head != null && head.val == val) {
            head = head.next;
        }

        // 如果全部头节点 都为目标val 实际上节点都被删光了
        if (head == null) {
            return null;
        }

        ListNode prev = head;
        // 如果 中间的节点 是需要被删除的
        // 如果不是最后一个节点
        while (prev.next != null) {
            // 如果是需要删除的 前一个节点
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                // 不是需要删除的前一个节点 头节点继续向后移动
                prev = prev.next;
            }
        }
        return head;
    }

}
