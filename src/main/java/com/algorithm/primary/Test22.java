package com.algorithm.primary;

/**
 * @Description
 * @Date 2023/2/1
 */
public class Test22 {

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

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        process(root,targetSum,0);
        return s;
    }

    boolean s = false;
    private void process(TreeNode root, int targetSum, int addNum) {
        //当是叶子节点，判断这个目标值是否和累加值相同，相同则返回true
        if(root.left == null && root.right == null){
            int a = root.val+addNum;
            if(a == targetSum){
                s = true;
            }
            return;
        }

        //当不是叶子节点，自己相加，然后再把值传下去
        addNum = addNum+root.val;
        if(root.left!=null){
            process(root.left,targetSum,addNum);
        }
        if(root.right!=null){
            process(root.right,targetSum,addNum);
        }
    }


}
