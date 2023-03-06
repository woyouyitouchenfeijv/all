package com.algorithm.system;

/**
 * @Description
 * @Date 2023/2/7
 */
public class Test2 {


    public static class Node{
        int value;
        Node next;
        public Node(int a , Node n){
            value = a;
            next = n;
        }
    }
    //单链表反转
    public static Node change(Node head){
        if(head.next == null ){
            return head;
        }
        Node b = null;
        while (head != null){
            Node mid =  head.next;
            head.next = b;
            b = head;
            head = mid;
        }
        return b;
    }

    public static Node change2(Node head){
        if(head.next == null ){
            return head;
        }
        Node pre = null;
        Node next = null;
        while (head != null){
            next =  head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main2(String[] args) {
        Node node5 = new Node(5, null);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);
        Node change = change2(node1);
        Node n = change;
        while (n!=null){
            System.out.println(n.value);
            n = n.next;
        }

    }






    //双链表
    public static class DoubleNode{
        DoubleNode in;
        DoubleNode out;
        int value;
        public DoubleNode(int data) {
            value = data;
        }
        public DoubleNode(DoubleNode i , DoubleNode o,int v){
            in = i;
            out = o;
            value = v;
        }
    }
    public static DoubleNode changeDoubleNode(DoubleNode head){
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null){
            next = head.out;
            head.out = pre;
            head.in = next;
            pre = head;
            head = next;
        }
        return pre;
    }


    public static void main(String[] args) {
        DoubleNode a3 = new DoubleNode(3);
        DoubleNode a2 = new DoubleNode(2);
        DoubleNode a1 = new DoubleNode(1);
        a1.in = null;
        a1.out = a2;
        a2.in = a1;
        a2.out = a3;
        a3.in = a2;
        a3.out = null;
        System.out.println(a1);
        DoubleNode doubleNode = changeDoubleNode(a1);
        System.out.println(1);


    }



}
