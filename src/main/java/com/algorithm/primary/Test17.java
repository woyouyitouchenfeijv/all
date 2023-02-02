package com.algorithm.primary;

/**
 * @Description
 * @Date 2023/1/30
 */
public class Test17 {
    public static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
        public TreeNode(int value){
            this.value = value;
        }
    }
    public static TreeNode setNode(){
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(9);
        TreeNode node7 = new TreeNode(5);
        node1.left = node2;
        node1.right = node5;
        node2.left = node3;
        node2.right = node4;
        node5.left = node6;
        node5.right = node7;
        return node1;
    }

    public static int maxDepth(TreeNode root) {
        if(root == null){
            return 0 ;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    public static void main(String[] args) {
        TreeNode treeNode = setNode();
        System.out.println(maxDepth(treeNode));
    }
}
