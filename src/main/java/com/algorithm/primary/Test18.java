package com.algorithm.primary;

import java.util.HashMap;

/**
 * @Description
 * @Date 2023/1/30
 */
public class Test18 {

    public static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
        public TreeNode(int value){
            this.value = value;
        }
    }

    /**
     * pre = [3,9,20,15,7], in = [9,3,15,20,7]
     */
    public TreeNode buildTree(int[] pre, int[] in) {

        if(pre.length != in.length || pre == null || in == null){
            return null;
        }
        HashMap<Integer,Integer> map = new HashMap();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i],i);
        }
        return  aa(pre,0,pre.length-1,in,0,in.length-1,map);
    }


    /**
     */
    public TreeNode aa(int[] pre, int L1, int R1, int[] in, int L2, int R2, HashMap<Integer,Integer> map) {
        if(L1 > R1){
            return null;
        }
        TreeNode treeNode = new TreeNode(pre[L1]);
        if(L1 == R1){
            return treeNode;
        }
        //中序里找到头在第几个
        int find = map.get(pre[L1]);
        treeNode.left = aa(pre,L1+1,(find-L2)+L1,in,L2,find-1,map);
        treeNode.right = aa(pre,(find-L2)+L1+1,R1,in,find+1,R2,map);
        return treeNode;
    }

}
