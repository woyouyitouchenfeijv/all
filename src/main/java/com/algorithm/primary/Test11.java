package com.algorithm.primary;

/**
 * @Description
 * @Date 2023/1/10
 */
public class Test11 {


    public class ListNode{
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; next = null;}
    }

    // 求链表长度
    public static int listLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    /**
     *  1-2-3-4-5
     *  1-2-3
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int length1 = listLength(l1);
        int length2 = listLength(l2);

        //选出来长度长的是 l 短的是 s
        ListNode l;
        ListNode s;
        if(length1 >= length2){
             l = l1;
             s = l2;
        }else{
            l = l2;
            s = l1;
        }
        //记录一个进位值
        int carry= 0;

        ListNode curL = l;
        ListNode curS = s;
        ListNode last = curL;
        //第一阶段，算 l 和 s 都有的情况，相加
        while (curS != null){
            //值相加
            int curNum = curL.val + curS.val + carry;
            //存到长链表
            curL.val = (curNum % 10);
            //计算是否进位，要用 / 而不能是 % 。因为 10 % 10 = 0  10/10 = 1；这个情况是只能用 /
            carry = curNum / 10;
            last = curL;
            curL = curL.next;
            curS = curS.next;
        }
        //第二阶段，算 l 自身
        while(curL != null){
            int curNum = curL.val + carry;
            curL.val = (curNum % 10);
            carry = curNum / 10;
            last = curL;
            curL = curL.next;
        }
        //第三阶段，算 是否还存在进位
        if(carry != 0){
            ListNode listNode = new ListNode(1);
            last.next = listNode;
        }
        return l;
    }




}
