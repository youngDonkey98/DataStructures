package com.donkey;

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

    public static void main(String[] args) {
        Integer i1 = 1;
        Integer i2 = 0;
        Integer i3 = 2;
        Integer i4 = -1;

        Integer max = getMin(i1, i2, i3, i4);
        System.out.println("max = " + max);

        System.out.println("i1.compareTo(i2) = " + i1.compareTo(i2));
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
