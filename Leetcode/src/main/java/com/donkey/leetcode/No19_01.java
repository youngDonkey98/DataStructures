package com.donkey.leetcode;

/**
 * @Author zwx
 * @Date 2021/5/16 11:02
 * @Description
 * @Modified By:
 * @Version:1.0.0
 */
public class No19_01 {

    public No19.ListNode removeNthFromEnd(No19.ListNode head, int n) {
        int temp = 0;
        No19.ListNode result = head;
        while(head != null){
            temp++; head = head.next;
        }

        if(n == temp)
            return result.next;

        // 将倒数第几个数 转成正数第几个数
        n = temp - n;
        head = result;
        temp = 1;
        while(head != null){
            if(temp == n){
                head.next = head.next.next;
                return result;
            }else{
                head = head.next;
                temp++;
            }
        }
        return result;
    }
}
