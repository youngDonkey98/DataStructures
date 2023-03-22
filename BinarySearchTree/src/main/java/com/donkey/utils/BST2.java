package com.donkey.utils;

/**
 * @author donkey
 * @version 1.0
 * @project DataStructures
 * @description
 * @date 2022/11/16 22:20:26
 */

// 继承Comparable 二分搜索树 元素具有可比性

// 我们的二分搜索树 不包含重复元素
    // 如果想包含重复元素 只需要定义为 左子树小于等于节点 or 右子树大于等于节点
public class BST2<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left;  // 左孩子
        public Node right; // 右孩子

        public Node (E e) {
            this.e = e;
            this.right = null;
            this.left = null;
        }
    }

    private Node root;
    private int size;

    public BST2() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public Boolean isEmpty() {
        return size == 0;
    }

    // 向二分搜素树中添加元素
    public void add(E e) {
        root = add(root,e);
    }

    // 向以node为根的二分搜索树中添加节点 E ,递归算法
    // 返回插入新节点后 二分搜索树的根
    // 将null 也当作一个Node
    private Node add(Node node,E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0 ) {
            node.left = add(node.left,e);
        } else if (e.compareTo(node.e) > 0){
            node.right = add(node.right,e);
        } else {
            // 如果node为空  什么都不做
        }
        return node;
    }

    // 查询二分搜索树中是否包含元素e
    public boolean contains(E e) {
        return contains(root,e);
    }

    // 递归方式
    // 看以node为根的二分搜索树中 是否包含e元素
    private boolean contains(Node node,E e) {
        if (node == null) {
            return false;
        } else {
            if (node.e.compareTo(e) == 0) {
                return true;
            } else if (node.e.compareTo(e) < 0) {
                return contains(node.left,e);
            } else {
                return contains(node.right,e);
            }
        }
    }

    // 非递归方式
    private boolean contains1(E e) {
        Node temp = root;

        if (temp == null) {
            return false;
        }
        if (temp.e.equals(e)) {
            return true;
        }

        while (temp != null) {
            if (temp.e.compareTo(e) == 0) {
                return true;
            } else if (temp.e.compareTo(e) < 0) {
                // 用该节点的左子树比较
                temp = temp.left;
            } else
                temp = temp.right;
        }
        return false;
    }
}
