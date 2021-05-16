package com.donkey.utils;

/**
 * @Author zwx
 * @Date 2021/5/13 23:21
 *
 *  添加链表的关键 找到添加节点之前位置的节点
 *      即 添加 2.5 需要找到 2 这个节点 (1   -- >    2 -- >    3 -- >    4 -- >    5)
 */
public class LinkedList<E> {

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

    @Deprecated
    private Node head;

    // 虚拟头节点
    private Node dummyHead;
    private int size;

//    public LinkedList() {
//        head = null;
//        size = 0;
//    }

    public LinkedList() {
        dummyHead = new Node(null,null);
        size = 0;
    }

    // 向链表中传入一个动态数组
    public LinkedList(Array<E> array) {
        size = array.getSize();
        for (int i = array.getSize(); i > 1; i--) {
            // TODO
            LinkedList<E> linkedList = new LinkedList<>();
            linkedList.addFirst1(array.get(i));
        }
    }

    public int getSize() {
        return size;
    }

    // 判断链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    @Deprecated
    // 向链表头部添加节点
    public void addFirst1(E e) {
//        // 将 e 存入Node中
//        Node<E> node = new Node<>(e);
//        // 将 node 的 next 指向原来的 head
//        node.next = head;
//        // 将 head 指向新的 node
//        head = node;

        // 上面三行代码等价于
        head = new Node(e,head);

        // 维护size
        size++;
    }

    /**
     * 向指定 "索引位置" 插入节点
     * prev
     *  1   -- >    2 -- >    3 -- >    4 -- >    5
     * 现在插入 2.5
     *            prev
     *  1   -- >    2 -- >    3 -- >    4 -- >    5
     *             将 2.next 指向 2.5
     *             将 2.5.next 指向 3
     *                   2.5
     *  2.5 ==new node(e)  ---> 2.5.next 即为：2.next  即为： node.next = prev.next
     *                          2.next 指向 2.5 即为： prev.next = node
     *
     *  将 插入节点的下一个 指针 指向3
     *  再将 原本指向3的指针 指向插入的节点
     *
     * @param index
     * @param e
     */
    @Deprecated
    public void add1(int index ,E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("索引不合法");
        }
        if (index == 0) {
            this.addFirst1(e);
        } else {
            Node prev = head;
            // 遍历 找到插入节点的 前一个节点
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
//            // 插入的数据
//            Node<E> node = new Node<>(e);
//            // 将 插入的节点 下一个指针 指向原本链表中 的下一个指针 （即为：prev.next）
//            node.next = prev.next;
//            // 将 prev.next 指向新插入的节点
//            prev.next = node;
            // 上面三行代码 等价于
            prev.next = new Node(e,prev.next);
            size++;
        }
    }

    public void add(int index ,E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("索引不合法");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e,prev.next);
        size++;
    }

    // 在链表末尾添加节点
    public void addLast(E e) {
        add(size,e);
    }

    public void addFirst(E e) {
        add(0,e);
    }

    // 获取下标为index位置的node值
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("索引不合法");
        }

        // 链表实际 第一个 节点
        Node cur = dummyHead.next;

        // 遍历到 想要的 下标
        /**
         *  dummy  -->  1   -- >    2 -- >    3 -- >    4 -- >    5
         *  index = 2   ===>  e = 3
         *  从 head 到 node(e = 3) 需要 next 2 次  1 -> 2 -> 3
         *  for (int i = 0; i < 2; i++)   ---->  index = 2  ----> for (int i = 0; i < index; i++)
         */
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    // 获得链表中第一个元素
    public E getFirst() {
        return get(0);
    }

    // 获得链表中最后一个元素
    public E getLast() {
        return get(size - 1);
    }

    // 修改链表中指定位置的元素
    public void set(int index,E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("索引不合法");
        }

        Node cur = dummyHead.next;

        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        cur.e = e;

    }

    // 删除指定节点
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("索引不合法");
        }

        // 移除节点的前一个节点
        Node prev = dummyHead;

        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        // 返回的节点
        Node retNode = prev.next;
        prev.next = retNode.next;  // prev.next = prev.next.next
        retNode.next = null; //GC
        size--;

        return retNode.e;
    }

    // 删除第一个节点
    public E removeFirst() {
        return remove(0);
    }

    // 删除最后一个节点
    public E removeLast() {
        return remove(size - 1);
    }

    // 是否存在
    public boolean contains(E e) {
        Node cur = dummyHead.next;

        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            // 没有找到 指向下一个节点
            cur = cur.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        // 第一个节点
//        Node cur = dummyHead.next;
//        while(cur != null) {
//            sb.append(cur + " -> ");
//            cur = cur.next;
//        }
        // 上面的代码等价于
        for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
            sb.append(cur + " -> ");
        }
        
        sb.append("NULL");

        return sb.toString();
    }

}
