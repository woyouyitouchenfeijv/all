package com.algorithm.primary;

/**
 * @Description
 * @Date 2023/1/31
 */
public class Test20 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    /**
     * 创建一个树的信息
     * 1、是否是平衡二叉树
     * 2、层级
     */
    public static class Info{
        boolean isBalanced;
        int height;
        public Info(boolean isBalanced,int height){
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public Info process(TreeNode root){
        if(root == null){
            return new Info(true,0);
        }
        Info leftProcess = process(root.left);
        Info rightProcess = process(root.right);
        boolean isBalanced = leftProcess.isBalanced && rightProcess.isBalanced
                && Math.abs(leftProcess.height - rightProcess.height) <2;
        int height = Math.max(leftProcess.height,rightProcess.height)+1;
        return new Info(isBalanced,height);
    }




}
