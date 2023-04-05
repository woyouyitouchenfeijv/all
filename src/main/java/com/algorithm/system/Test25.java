package com.algorithm.system;

import java.util.Stack;

/**
 * @Description
 * @Date 2023/3/22
 */
public class Test25 {

    static class T1 {
        //定义 - 不重复

        public static int[][] getNearLessNoRepeat(int[] arr) {
            if (arr == null || arr.length == 0) {
                return null;
            }
            int[][] res = new int[arr.length][2];
            Stack<Integer> stack = new Stack<>();
            //这一大块for可以简化
            for (int i = 0; i < arr.length; i++) {
                //栈为空直接存，因为if，else 都要push ，所以不要了
                //if (stack.isEmpty()) {
                //  stack.push(i);
                //} else {
                //拿到栈顶的值
                //int j = stack.peek();
                //得一直循环比，
                while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                    //不为空，比大小
                    //如果外面的值大于栈顶 - 所以这块也不存在了
                    //if(arr[i] > arr[j]){
                    //stack.push(i);
                    //}else{
                    //弹出栈
                    int j = stack.pop();
                    //判断栈是否为空
                    int rightMin = stack.isEmpty() ? -1 : stack.peek();
                    res[j][0] = rightMin;
                    res[j][1] = i;
                    //}
                }
                stack.push(i);
                //}
            }
            //最后，如果栈里还有数据
            while (!stack.isEmpty()) {
                int j = stack.pop();
                int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
                res[j][0] = leftLessIndex;
                res[j][1] = -1;
            }
            return res;
        }

        //定义  - 重复
        public static int[][] getNearLessNoRepeat2(int[] arr) {
            return null;
        }
    }


    /**
     * 给定一个只包含正数的数组arr，arr中任何一个子数组sub，
     * 一定都可以算出(sub累加和 )* (sub中的最小值)是什么，
     * 那么所有子数组中，这个值最大是多少？
     */
    static class T2 {


        public static void main(String[] args) {
            int[] arr = {1, 3, 5, 6, 7};


        }
    }



}


/**
 * static class T6 {
 *  }
 */
