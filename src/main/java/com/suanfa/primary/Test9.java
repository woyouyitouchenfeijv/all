package com.suanfa.primary;


/**
 * @Description
 * @Date 2023/1/5
 */
public class Test9 {
    /*
     * 双链表结构
     **/
    public static class DoubleNode {
        public int value;
        public DoubleNode in;
        public DoubleNode out;

        public DoubleNode(int data) {
            value = data;
        }
    }


    /**
     * 转换顺序
     */
    public static DoubleNode changeDoubleNode (DoubleNode head){

        //进来之后，需要记录header的上一个指针对象，因为head的上一个是null，所以pre是null
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null){
            //记录下一个是谁，给next
            next = head.in;
            //先修改下一个指针，指向pre
            head.in = pre;
            //之前head的上一个改成指向下一个，下一个刚刚记录了就是next
            head.out = next;
            //修改指针
            pre = head;
            //程序继续向下走，修改head
            head = next;
        }
        return pre;
    }

    /**
     * 生成一个双向链表
     */
    public static DoubleNode getDoubleNode(int maxLength,int maxValue){
        if(maxLength == 0){
            return null;
        }
        //随机一个最大值
        int length = (int)(Math.random()*maxLength);
        length = 5;
        System.out.println("长度"+length);
        DoubleNode doubleNode1 = new DoubleNode((int) (Math.random() * maxValue));
        if(length == 0){
            return doubleNode1;
        }
        //填值---
        /**
         * 一开始，头和指针在一起
         */
        //头对象
        DoubleNode header = doubleNode1;
        //指针，因为要返回头，里面都用指针进行变化。一开始指针就在头
        DoubleNode pre = header;

        for (int i = 1; i < length-1; i++) {
            //随机一个
            DoubleNode cur = new DoubleNode((int) (Math.random() * maxValue));
            //指针的下一个就是新生成的
            pre.in = cur;
            //新生成的上指针是pre
            cur.out = pre;
            //指针指向下一个
            pre = cur;
        }
        return header;
    }

    public static void main(String[] args) {
        //生成双线链表

        DoubleNode doubleNode = getDoubleNode(5, 5);
        System.out.println(doubleNode);

    }
}
