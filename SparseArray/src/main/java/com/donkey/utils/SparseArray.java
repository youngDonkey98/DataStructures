package com.donkey.utils;

/**
 * @Author zwx
 * @Date 2021/4/26 15:51
 * @Description 稀疏数组
 */
public class SparseArray {
    /**
     * 当一个二维数组中 存在多个相同的数 或 大多数都是默认数0时 可以使用稀疏数组存储
     *
     * 例子 （ 7 x 7） ：
     *  0 0 0 0 0 0 0
     *  0 1 0 0 0 0 0
     *  0 0 0 2 0 0 0
     *    中间都是 0
     *  0 0 0 0 0 0 0
     *
     *    ↓ ↓
     *  变成稀疏数组 ：
     *       row  col  value
     *  [0]   7    7    2   首行为二维数组行列数以及不为0的个数
     *  [1]   1    1    1
     *  [2]   2    3    2
     *
     */

    public static void main(String[] args) {

        // 二维数组
        // 0 为没有棋子  1 为黑棋  2 为白棋
        int chessArray1[][] = new int[7][7];
        chessArray1[1][1] = 1;
        chessArray1[2][3] = 2;

        // 将二维数组变成稀疏数组
        // 遍历原始二维数组 看看有几个不为0的值
        int sum = 0;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (chessArray1[i][j] != 0) {
                    sum++;
                }
            }
        }

        int count = 0;  // 稀疏数组计数器
        // 初始化稀疏数组
        int chessArray2[][] = new int[sum+1][3];
        chessArray2[0][0] = 7;
        chessArray2[0][1] = 7;
        chessArray2[0][2] = sum;
        System.out.println("chessArray1.length = " + chessArray1.length);
        for (int i = 0; i < chessArray1.length; i++) {
            for (int j = 0; j < chessArray1.length; j++) {
                if (chessArray1[i][j] != 0) {
                    count++;
                    chessArray2[count][0] = i;
                    chessArray2[count][1] = j;
                    chessArray2[count][2] = chessArray1[i][j];
                }
            }
        }

        System.out.println("得到的稀疏数组");
        for (int i = 0; i < chessArray2.length; i++) {
            System.out.printf("%s\t%s\t%s\n",chessArray2[i][0],chessArray2[i][1],chessArray2[i][2]);
        }

        // 将稀疏数组转成二维数组
        // 创建原始数组
        int[][] chessArray3 = new int[chessArray2[0][0]][chessArray2[0][1]];
        for (int i = 0; i < chessArray2.length; i++) {
            chessArray3[chessArray2[i][0]][chessArray2[i][1]] = chessArray2[i][2];
        }
    }
}
