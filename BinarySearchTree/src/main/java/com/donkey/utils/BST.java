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
public class BST<E extends Comparable<E>> {

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

    public BST() {
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
    private void add(Node node,E e) {

        if (e.equals(node.e)) {
            return;
        } else if (node.e.compareTo(e) < 0 && node.left == null) {
            node.left = new Node(e);
            size ++;
            return;
        } else if (node.e.compareTo(e) > 0 && node.right == null){
            node.right = new Node(e);
            size ++;
            return;
        }

        if (e.compareTo(node.e) < 0 ) {
            add(node.left,e);
            // 必定是 e.compareTo(node.e) > 0 的情况   == 0 的情况在 58行就判断了
        } else {
            add(node.right,e);
        }
    }
}
