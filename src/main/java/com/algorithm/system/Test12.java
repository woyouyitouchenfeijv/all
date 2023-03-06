package com.algorithm.system;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description
 * @Date 2023/2/20
 */
public class Test12 {

    public static class Node{
        Node left;
        Node right;
        int value;
        public Node(int a){
            value = a;
        }
    }
    

    public static Node getNode(){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        return node1;
    }


    /**
     * 按层遍历
     *
     * 准备一个队列 queue
     * 第一个节点进去，然后弹出，有左进左，有右进右
     * 直到queue为空
     *
     *
     */


    //不用递归
    public static void ceng(Node head){
        Queue<Node> queue = new LinkedList();
        queue.add(head);
        while (!queue.isEmpty()){
            Node poll = queue.poll();
            System.out.println(poll.value);
            if(poll.left != null){
                queue.add(poll.left);
            }
            if(poll.right != null){
                queue.add(poll.right);
            }
        }
    }

    /**
     * 最大层
     */


    /**
     * 找下级
     *
     * 节点
     * 左、有，父
     *
     * 1、给的节点，如果有右，右节点拿到，然后一直找到右节点的最左，就是下一个
     * 2、给的节点，如果没有右，先找到自己的父，如果不属于父的右节点，一直向上找，直到找到
     *
     */


    /**
     * 折痕
     */



}
