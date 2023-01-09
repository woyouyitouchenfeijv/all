package com.suanfa.primary;

/**
 * @Description
 * @Date 2023/1/5
 */
public class Test8 {


    //单链表对象
    public static class Node<T>{
        public T value;
        public Node<T> next;


        public  Node(T data){
            value = data;
            next = null;
        }
    }
    //链表串
    public static class MyNode{
        public Node head;
        public Node last;
        public int size;
    }


    /**
     * 从前往后算
     */
    public static Node<Integer> getMyNode(int maxLength , int maxValue){
        if(maxLength <= 0){
            return  null;
        }
        Node head = new Node(0);

        //随机一个长度
        int length = (int)(Math.random()*maxLength);
        System.out.println("长度"+length);
        //填充值
        Node mid = head;
        for (int i = 1; i < length; i++) {
            Node node = new Node(i);
            mid.next = node;
            mid = node;
        }
        return head;
    }


    /**
     * 从后往前算
     */
    public static Node<Integer> getMyNode2(int maxLength){
        if(maxLength <= 0){
            return  null;
        }

        //随机一个长度
        int length = (int)(Math.random()*maxLength);
        Node last = new Node(length-1);
        System.out.println("长度"+length);
        //填充值
        Node mid = last;
        for (int i = length-2; i >= 0 ; i--) {
            Node head = new Node(i);
            head.next = mid;
            mid = head;
            if(i == 0){
                return head;
            }

        }
        return last;
    }

    //输出
    public static void soutNode(Node myNode){
        while (myNode != null){
            System.out.print(myNode.value+",");
            myNode = myNode.next;
        }
        System.out.println();
    }
    //逆序
    public static Node changeNode(Node head){
        Node up = null;
        Node next = null;
        while (head != null) {
            //记录head的下一个
            next = head.next;
            //head.next指向上一个,第一次就是指向null
            head.next = up;
            //记录一些上一个，上一个是head
            up = head;
            //程序继续走，head要变成下一个
            head = next;
        }
        return up;
    }



    public static void main(String[] args) {
        /*Node<Integer> myNode = getMyNode(100, 5);
        Node<Integer> myNode2 = getMyNode2(100);
        while (myNode != null){
            System.out.print(myNode.value+",");
            myNode = myNode.next;
        }
        System.out.println();
        System.out.println("---");
        while (myNode2 != null){
            System.out.print(myNode2.value+",");
            myNode2 = myNode2.next;
        }*/
        Node<Integer> myNode = getMyNode(100, 5);
        soutNode(myNode);
        System.out.println("=====");
        Node node = changeNode(myNode);
        soutNode(node);
    }


}
