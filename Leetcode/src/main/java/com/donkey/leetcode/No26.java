package com.donkey.leetcode;

/**
 * @Author zwx
 * @Date 2021/5/17 9:43
 * @Description 26. 删除有序数组中的重复项 返回现在数组的长度
 *      [1 , 1 , 2 , 3 , 3]  ----> [ 1 , 2 , 3]
 *      [1 , 2 , 2 , 2 , 3]  ----> [ 1 , 2 , 3]
 *
 *      执行时间：1ms
 *      内存消耗：40.4MB
 */
public class No26 {

    public int removeDuplicates(int[] nums) {
        int head = 0;
        int prev = 1;
        if (nums.length == 0) {
            return 0;
        }
        while (prev < nums.length) {
            if (nums[head] != nums[prev]) {
                nums[head + 1] = nums[prev];
                head++;
            }
            prev++;
        }
        return head + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,3,4,4,4};
        System.out.println(new No26().removeDuplicates(nums));
    }
}
