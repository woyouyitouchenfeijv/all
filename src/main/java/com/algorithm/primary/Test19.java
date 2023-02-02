package com.algorithm.primary;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description
 * @Date 2023/1/31
 */
public class Test19 {


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
     * 一个数组 算size
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list  = new LinkedList<>();
        if(root == null){
            return list;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            int size = q.size();
            List<Integer> valueList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = q.poll();
                valueList.add(poll.val);
                if(poll.left != null){
                    q.add(poll.left);
                }
                if(poll.right != null){
                    q.add(poll.right);
                }
            }
            list.add(0,valueList);
        }
        return list;
    }




}
