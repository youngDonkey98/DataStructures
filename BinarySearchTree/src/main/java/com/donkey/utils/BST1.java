package com.donkey.utils;

/**
 * @author donke
 * @version 1.0
 * @project DataStructures
 * @description
 * @date 2022/11/16 22:20:26
 */

// 继承Comparable 二分搜索树 元素具有可比性
public class BST1<E extends Comparable<E>> {

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

    public BST1() {
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
        if (root == null) {
            root = new Node(e);
            size ++;
        } else {
            add(root,e);
        }
    }

    // 向以node为根的二分搜索树中添加节点 E ,递归算法
    private void add(Node node, E e) {

        if (e.equals(node.e)) {
            return;
        } else if (node.e.compareTo(e) < 0) {
            if (node.right == null) {
                node.right = new Node(e);
                size++;
                return;
            } else {
                add(node.right, e);
            }
        } else {
            if (node.left == null) {
                node.left = new Node(e);
                size++;
                return;
            } else {
                add(node.left, e);
            }
        }
    }
}
