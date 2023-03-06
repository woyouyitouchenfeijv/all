package com.algorithm.system;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description
 * @Date 2023/2/21
 */
public class Test13 {


    /**
     * 算两个节点之间的最大距离
     */


  public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public  static String xulie(TreeNode root,String str){

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

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(4);
        treeNode.right.right = new TreeNode(5);
        String xulie = xulie(treeNode, "");
        System.out.println(xulie(treeNode,""));
        System.out.println(deserialize(xulie));
        System.out.println(1);
    }

}
