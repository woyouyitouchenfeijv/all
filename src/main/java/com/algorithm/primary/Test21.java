package com.algorithm.primary;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Date 2023/2/1
 */
public class Test21 {



    public static class TreeNode {
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
     * 1、中序是升序列，那就是一个搜索二叉树。
     */
    List<Integer> res = new LinkedList<>();
    int[] aaa = new int[]{};
    int num = 0;
    public boolean midSort(TreeNode root) {
        if(root==null)
            return true;
        inOrder(root);
        for(int i=1;i<aaa.length;i++){
            if(aaa[i]<=aaa[i-1]){
                return false;
            }
        }
        return true;
    }

    private void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        aaa[num] = root.val;
        num++;
        inOrder(root.right);
    }








}
