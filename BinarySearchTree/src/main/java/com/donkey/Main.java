package com.donkey;

import com.donkey.utils.BST;

/***
 * 二叉树
 *  二叉树具有唯一根节点
 *  二叉树每个节点最多有两个孩子
 *  二叉树每个节点最多有一个父亲节点
 *
 *  二叉树具有天然的递归结构 ： 每一个节点的左,右子树也是一个二叉树
 *  二叉树不一定是 “满”的
 *      一个节点 也是二叉树
 *      null 也是二叉树
 *
 *  叶子节点
 *      没有孩子节点的节点
 *  根节点
 *      没有父亲节点的节点
 *
 *
 * 二分搜索树  Binary Search Tree
 *      二分搜索树是二叉树
 *      二分搜索树的每一个节点的值 大于其左子树的所有的节点的值 小于其右子树的所有的节点的值
 *      二分搜索树的每一棵子树 都是二分搜索树
 *
 *      二分搜索树 存储的元素必须有可比较性 （可以看作是局限性）
 */
public class Main {

    //////////////////
    //      5       //
    //     /  \     //
    //   3     7    //
    //  / \   / \   //
    // 2   4 6   8  //
    //////////////////
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5,3,4,7,6,8,2};
        for (int num : nums) {
            bst.add(num);
        }
        bst.preOrder();

        // 中序排序 由小到大
        System.out.println();
        bst.inOrder();

        // 后续排序 由下到上
        //          一个节点 左右子树 根节点
        System.out.println();   // 2 4 3 6 8 7 5
        bst.postOrder();
    }

    public static <E extends Comparable> E getMax(E e1,E e2) {
        return e1.compareTo(e2) == 1 ? e1 : e2;
    }

    public static <E extends Comparable> E getMax(E... agrs) {
        E max = null;
        for (int i = 1; i < agrs.length; i++) {
            if (i == 1) {
                max = getMax(agrs[i - 1], agrs[i]);
            } else {
                max = getMax(max,agrs[i]);
            }
        }
        return max;
    }

    public static <E extends Comparable> E getMin(E... agrs) {
        E min = null;
        for (int i = 1; i < agrs.length; i++) {
            if (i == 1) {
                min = getMin(agrs[i - 1], agrs[i]);
            } else {
                min = getMin(min,agrs[i]);
            }
        }
        return min;
    }

    public static <E extends Comparable> E getMin(E e1,E e2) {
        return e1.compareTo(e2) == -1 ? e1 : e2;
    }
}
