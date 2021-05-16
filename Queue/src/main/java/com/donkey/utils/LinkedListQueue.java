package com.donkey.utils;

/**
 * @Author zwx
 * @Date 2021/5/16 17:23
 * 使用链表实现队列
 *      设置 head 和 tail 两个节点 分别指向头 尾
 *      Node 中 只有 next 指针
 *      删除需要找到 删除节点的前一个节点
 *      因为 node 中 只有 next 指针 所以 tail 并不方便找到 前一个节点
 *      因此 head 为 头部 出队  tail 为 尾部 入队
 */
public class LinkedListQueue<E> implements Queue<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e,Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e,null);
        }

        public Node() {
            this(null,null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    // 入队操作
    @Override
    public void enqueue(E e) {
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            // 维护tail指向
            tail = tail.next;
        }
        size++;
    }

    // 出队操作
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw  new IllegalArgumentException("队列为空");
        }
        Node retNode = head;
        head = head.next;
        retNode.next = null;
        size--;
        // 意味着队列空了
        if (head == null) {
            tail = null;
        }
        return retNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw  new IllegalArgumentException("队列为空");
        }
        return head.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        // 第一个节点
        Node cur = head;
        while(cur != null) {
            sb.append("LinkedListQueue head:");
            sb.append(cur + " -> ");
            cur = cur.next;
        }
        sb.append("NULL  tail");

        return sb.toString();
    }

}
