package com.likou;

/**
 * @Description
 * @Date 2022/12/19
 * <p>
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例 1：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic2 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode listNode = new ListNode();
        boolean add = false;

        while (l1 != null && l2 !=null){
            //判断是否是0
            int var1 = l1 != null ? l1.val : 0;
            int var2 = l2 != null ? l2.val : 0;
            int var3 = var1 + var2 ;
            //相加，判断是否大于9 是往前进一位
            if(var3 > 9){
                add = true;
                var3 = var3 %10;
            }
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
            //拼接 - 目前没明白listNode结构，所以不知道怎么拼接
        }

        return null;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2, boolean i) {
        if (l1 == null && l2 == null && !i) return null;
        l1 = l1 == null ? new ListNode() : l1;
        l2 = l2 == null ? new ListNode() : l2;
        int val = l1.val + l2.val + (i ? 1 : 0);
        ListNode result = addTwoNumbers(l1.next, l2.next, val > 9);
        l1.next = result;
        l1.val = val % 10;
        return l1;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}

