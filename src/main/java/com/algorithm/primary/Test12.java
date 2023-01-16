package com.algorithm.primary;

/**
 * @Description
 * @Date 2023/1/10
 */
public class Test12 {

    public class ListNode{
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; next = null;}
    }


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        //为空直接返回
        if(list1 == null || list2 == null){
            return  list1 == null ? list1 : list2;
        }
        //判断第一个谁小，谁就是头 相当的话就是选一个即可
        ListNode head = list1.val < list2.val ? list1 : list2;
        //拿到另一个
        ListNode cur2 = head == list1 ? list2 : list1;
        //已经拿到小的了，所以下次比对就是head的下一个值
        ListNode cur1 = head.next;
        //当前的值，就是head
        ListNode pre = head;
        //都不为空可以next，为空说明又一个链表短。已经完事了
        while (cur1 != null && cur2 !=null){
            //谁小，pre的下一个就是谁，那个节点往下走一步
            if(cur1.val < cur2.val){
                pre.next = cur1;
                cur1 = cur1.next;
            }else{
                pre.next = cur2;
                cur2 = cur2.next;
            }
            //当前值也往下走一步
            pre = pre.next;
        }
        //都完成，是因为谁空了，pre的下一个指向谁。如果都为null，cur1 和 cur2其实也是null，指向也无所谓
        pre.next = cur1 == null ? cur2 : cur1;
        return head;
    }

    public static void main(String[] args) {
        System.out.println(5<<1);
    }


}
