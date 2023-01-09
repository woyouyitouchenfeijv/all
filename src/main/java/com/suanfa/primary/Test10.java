package com.suanfa.primary;

/**
 * @Description
 * @Date 2023/1/6
 */
public class Test10 {




    public static class ListNode{
        public int value;
        public ListNode next;
    }


    public static ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode next = null;
        while (head != null){
            next =  head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 链表是 1>2>3>4>5>6   变成两个  1>2>3    4>5>6
     * 将start 和 end 逆序 变成 3>2>1   6>5>4
     *
     * 本来是 3指向4。改成 1指向6
     */

    public static void reverseNode(ListNode start , ListNode end){
        //记录start的头
        ListNode startHead = start;
        start =  reverse(start);
        end = reverse(end);
        //start 的头指向end逆序后的头
        startHead.next = end;
    }


    //到k返回k的函数
    public static ListNode getKNode(ListNode node,int k){
        ListNode cur = null;
        for (int i = 0; i < k; i++) {
            if(node.next != null){
                cur = node.next;
            }else{
                return null;
            }
        }
        return cur;
    }


    public static ListNode reverseKGroup(ListNode head,int k){
        //记录一下第一个
        ListNode start = head;
        //拿到从start到k的值
        ListNode end = getKNode(start, k);
        if(end == null){
            return null;
        }
        head = end;
        reverseNode(start,end);
        ListNode lastEnd = start;
        while (lastEnd.next != null){
            start = lastEnd.next;
            end = getKNode(start, k);
            if(end == null){
                return null;
            }
            reverseNode(start,end);
            lastEnd.next = end;
            lastEnd = start;

        }
        return head;
    }



    public static void main(String[] args) {

    }

}
