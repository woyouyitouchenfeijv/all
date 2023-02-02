package com.algorithm.primary;

/**
 * @Description
 * @Date 2023/1/30
 */
public class Test16 {


    public static class Node{
        int value;
        Node left;
        Node right;
        public Node(int value){
            this.value = value;
        }
    }

    /**
     *     填充值
     *
     *     10
     *  8     3
     * 6 2   9 5
     */
    public static Node setNode(){
        Node node1 = new Node(10);
        Node node2 = new Node(8);
        Node node3 = new Node(6);
        Node node4 = new Node(2);
        Node node5 = new Node(3);
        Node node6 = new Node(9);
        Node node7 = new Node(5);
        node1.left = node2;
        node1.right = node5;
        node2.left = node3;
        node2.right = node4;
        node5.left = node6;
        node5.right = node7;
        return node1;
    }

    public static void main(String[] args) {
        Node node = setNode();
        printLeft(node);
        System.out.println("");
        printRight(node);
    }



    //打印左序 - 头 -> 左  -> 右
    public static void printLeft(Node node){
        if(node == null ){
            return;
        }
        System.out.print(node.value);
        printLeft(node.left);
        printLeft(node.right);
    }


    //打印中序 - 左 -> 头 -> 右
    public static void printRight(Node node){
        if(node == null ){
            return;
        }
        printRight(node.left);
        System.out.print(node.value);
        printRight(node.right);
    }

    //判断是否相同
    public static boolean compareNode(Node p , Node q){
        //有一个为null 是false
        if(p == null ^ q == null){
            return false;
        }
        //都为null 是true
        if(p == null && q == null){
            return true;
        }
        return p.value == q.value && compareNode(p.left,q.left) && compareNode(p.right,q.right);
    }




}
