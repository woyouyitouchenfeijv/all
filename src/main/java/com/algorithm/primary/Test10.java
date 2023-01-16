package com.algorithm.primary;

/**
 * @Description
 * @Date 2023/1/6
 */
public class Test10 {




    public static class ListNode{
        public int value;
        public ListNode next;
        public  ListNode(int data){
            value = data;
        }
    }



    /**
     * 链表是 1-2-3-4-5-6 长度是2
     */
    public static void reverse(ListNode start , ListNode end){
        //传进来的end就是2 ，记录一下他的下一个,end =3
        end = end.next;
        //start 逆序
        ListNode pre = null;
        ListNode head = start;
        ListNode next = null;
        //只要head 没到4就继续换
        while (head != end){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        start.next = end;
    }


    //到k返回k的函数
    public static ListNode getKGroupEnd(ListNode node,int k){
        for (int i = 1; i < k; i++) {
            if(node != null){
                node = node.next;
            }
        }
        return node;
    }


    //1-2-3-4-5-6  2
    public static ListNode reverseKGroup(ListNode head,int k){
        //记录一下第一个 也就是1
        ListNode start = head;
        //拿到从start到k的值 k=2  end就是 2
        ListNode end = getKGroupEnd(start, k);
        //不足2个，返回head
        if(end == null){
            return head;
        }
        //到这里，说明够2个一组。下次head就从之前的结尾开始，所以head = end = 2
        head = end;
        //第一组旋转
        reverse(start,end);
        //start因为在第一句是head 当时head还是1 所以start也是1 。但是经过旋转，1已经是第一组的末尾。所以第一组的最后一个值lastEnd = 1
        ListNode lastEnd = start;
        while (lastEnd.next != null){
            //1 的下一个是3
            start = lastEnd.next;
            //end = 4
            end = getKGroupEnd(start, k);
            if(end == null){
                return head;
            }
            //转换完，已经是 2-1-3  4-3-5-6。注意，1 指向的是3不是4
            reverse(start,end);
            //关联上1和4  变成 2-1-4-3-5-6
            lastEnd.next = end;
            //lastEnd 变成 3
            lastEnd = start;

        }
        return head;
    }





}
