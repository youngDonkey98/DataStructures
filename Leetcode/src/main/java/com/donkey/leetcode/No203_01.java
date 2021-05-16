package com.donkey.leetcode;

/**
 * @Author zwx
 * @Date 2021/5/16 22:13
 * @Description
 * @Modified By:
 * @Version:1.0.0
 */
public class No203_01 {
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

        // 使用虚拟头节点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        // 链表中的所有节点 都有前一个节点了
        ListNode prev = dummyHead;
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
        return dummyHead.next;
    }
}
