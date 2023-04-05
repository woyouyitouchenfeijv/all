package com.algorithm.system;

import java.util.*;

/**
 * @Description
 * @Date 2023/2/16
 */
public class Test11 {
    /**
     * 先序 - 头 左 右
     * 中序 - 左 头 右
     * 后序 - 左 右 头
     */

    public static class Node{
        Node left;
        Node right;
        int value;
        public Node(int a){
            value = a;
        }
    }


    //递归方法--------begin
    public static void leftSort(Node node){
        if(node == null){
            return;
        }
        leftSort(node.left);
        leftSort(node.right);
        System.out.print(node.value+"-");
    }
    //递归方法--------end




    //非递归-------- 左
    public static void leftSort2(Node node){
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.empty()){
            Node peek = stack.pop();
            System.out.print(peek.value+"-");
            if(peek.right!=null){
                stack.push(peek.right);
            }
            if(peek.left!=null){
                stack.push(peek.left);
            }
        }
    }

    /**
     * 非递归-------- 中
     *
     *
     * 先把所有的左存到栈，然后弹出一个，看有没有右，右了存进去
     */

    public static void midSort2(Node node){
        if(node == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node pre = node;
        //头加进去
        stack.push(pre);
        while (!stack.empty()){
            //把所有的左加进去
            while (pre.left != null){
                stack.push(pre.left);
                pre = pre.left;
            }
            //弹出
            pre = stack.pop();
            System.out.print(pre.value+"-");
            /**
             * 看弹出的人有没有右，没有下一个，因为左已经全在里面了，所以指针不动
             * 有了指针指右，再把右的所有左存进去
             */
            if(pre.right!=null){
                stack.push(pre.right);
                pre = pre.right;
            }
        }


    }

    public static void midSort3(Node node){
        if(node == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        while (!stack.empty() || node != null){
            //这个if会存入所有的左，直到左是null
            if(node != null){
                //把自己加进去
                stack.push(node);
                //指向左
                node = node.left;
            }else{
                //node 为null，说明左边加完了，因此弹出第一个
                node = stack.pop();
                System.out.print(node.value + "-");
                //然后指向右。如果右右边，会先指向加右边的所有左，如果右边为null，继续弹
                node = node.right;
            }
        }


    }


    public static void sort3(Node node){
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.empty()){
            Node peek = stack.pop();
            System.out.print(peek.value+"-");
            if(peek.left!=null){
                stack.push(peek.left);
            }
            if(peek.right!=null){
                stack.push(peek.right);
            }

        }
    }



    public static void main(String[] args) {
        //1-2-4-5-3-6-7- 左
        //4-2-5-1-6-3-7- 中
        //4-5-2-6-7-3-1- 后
        Node node = getNode();
        //leftSort(node);
        leftSort2(node);
        System.out.println();
        midSort2(node);
        System.out.println();
        midSort3(node);
        System.out.println();
        sort3(node);
        System.out.println();
        pos2(node);

    }

    public static void pos2(Node h) {
        System.out.print("pos-order: ");
        if (h != null) {
            Stack<Node> stack = new Stack<Node>();
            stack.push(h);
            Node c = null;
            while (!stack.isEmpty()) {
                c = stack.peek();
                if (c.left != null && h != c.left && h != c.right) {
                    stack.push(c.left);
                } else if (c.right != null && h != c.right) {
                    stack.push(c.right);
                } else {
                    System.out.print(stack.pop().value + " ");
                    h = c;
                }
            }
        }
        System.out.println();
    }

    /**
     *     1
     *  2     3
     *  45    67
     */
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

    static class a {
        public static void main(String[] args) {
            Node node = getNode();
            System.out.println(process(node, ""));

        }



        public static String process(Node root, String str) {
            //如果root是空，直接return ,字符串拼接一个null
            if(root == null){
                str += "null,";
                return str;
            }
            //用先序遍历,存到字符串 因为题目要求先输出头，所以一定是先序
            //左进去
            str = process(root.left,str);
            str += str.valueOf(root.value) + ",";
            //右进去
            str = process(root.right,str);
            return str;
        }




    }
    //序列化和返序列化

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public  static String xulie(TreeNode root, String str){

        if(root == null){
            str += "null,";
            return str;
        }
        str += str.valueOf(root.val) + ",";
        str = xulie(root.left,str);
        str = xulie(root.right,str);
        return str;
    }


    public static TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        Queue<Integer> a = new LinkedList<Integer>();
        for (String s : dataArray) {
            if("null".equals(s)){
                a.add(null);
            }else{
                a.add(Integer.valueOf(s));
            }
        }
        return rdeserialize(a);
    }

    private static TreeNode rdeserialize(Queue<Integer> a) {
        if(a.isEmpty()){
            return null;
        }
        TreeNode treeNode = null;
        Integer poll = a.poll();
        if(poll!=null){
            treeNode = new TreeNode(poll);
            treeNode.left = rdeserialize(a);
            treeNode.right = rdeserialize(a);
        }
        return treeNode;
    }

    static class b{

        public static TreeSet<String> process(String[] strs) {
            TreeSet<String> ans = new TreeSet<>();
            if (strs.length == 0) {
                ans.add("");
                return ans;
            }
            for (int i = 0; i < strs.length; i++) {
                String first = strs[i];
                String[] nexts = removeIndexString(strs, i);
                TreeSet<String> next = process(nexts);
                for (String cur : next) {
                    ans.add(first + cur);
                }
            }
            return ans;
        }

        public static String[] removeIndexString(String[] arr, int index) {
            int N = arr.length;
            String[] ans = new String[N - 1];
            int ansIndex = 0;
            for (int i = 0; i < N; i++) {
                if (i != index) {
                    ans[ansIndex++] = arr[i];
                }
            }
            return ans;
        }


        public static boolean aaa(int[] nums){
            int i = 0;
            for (int j = 0; j < nums.length; j++) {
                i = i+nums[j];
                if(i >= nums.length ){
                    return true;
                }
            }
            return false;
        }
        public static boolean bbb (int [] nums){
            int i = 0, maxIndex = 0;
            while (i <= maxIndex) {
                System.out.println(maxIndex+"---"+(i + nums[i]));
                maxIndex = Math.max(maxIndex, i + nums[i]);
                if (maxIndex >= nums.length - 1)
                    return true;
                i++;
            }
            return false;

        }


        /**
         * Queue - 先进先出
         * Stack - 先进后出
         * PriorityQueue - 排序由大到小出
         */

//        public static void main(String[] args) {
//            PriorityQueue<Object> objects = new PriorityQueue<>();
//            Queue a = new LinkedList<Integer>();
//            a.add(1);
//            a.add(2);
//            a.add(0);
//            while (!a.isEmpty())
//                System.out.println(a.poll());
//        }
    }

}
