package com.algorithm.system;

/**
 * @Description
 * @Date 2023/3/13
 */
public class Test21 {

    //最小路径和 - 从左往右尝试模型

    /**
     * 给定一个二维数组matrix，一个人必须从左上角出发，最后到达右下角
     * 沿途只可以向下或者向右走，沿途的数字都累加就是距离累加和
     * 返回最小距离累加和
     */
    //我所有的值，都依赖我的上一个和左一个。选个小的
    public static int process(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;
        int[][] res = new int[row][col];
        res[0][0] = arr[0][0];
        for (int i = 1; i < col; i++) {
            res[0][i] = res[0][i - 1] + arr[0][i];
        }
        for (int i = 1; i < row; i++) {
            res[i][0] = res[i - 1][0] + arr[i][0];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                res[i][j] = Math.min(res[i - 1][j], res[i][j - 1]) + arr[i][j];
            }

        }
        return res[row - 1][col - 1];
    }


    public static int process2(int[][] arr) {
        int row = arr.length;
        int[] res = new int[row];
        res[0] = arr[0][0];
        for (int i = 1; i < row; i++) {
            res[i] = res[i - 1] + arr[0][i];
        }
        for (int i = 1; i < row; i++) {
            res[0] = res[0] + arr[i][0];
            for (int j = 1; j < row; j++) {
                res[j] = Math.min(res[j - 1], res[j]) + arr[i][j];
            }
        }
        return res[row - 1];
    }


    //选钱 - 从左往右尝试

    /**
     * arr是面值数组，其中的值都是正数且没有重复。再给定一个正数aim。
     * 每个值都认为是一种面值，且认为张数是无限的。
     * 返回组成aim的方法数
     * 例如：arr = {1,2}，aim = 4
     * 方法如下：1+1+1+1、1+1+2、2+2
     * 一共就3种方法，所以返回3
     */
    //index  - 到哪个位置
    public static int xuan(int[] arr, int index, int result) {
        if (index == arr.length) {
            return result == 0 ? 1 : 0;
        }
        int res = 0;
        //选的张数，只要小于最终值，我可以一直选。0张 1张。。。。。。
        for (int zhang = 0; arr[index] * zhang <= result; zhang++) {
            res += xuan(arr, index + 1, result - arr[index] * zhang);
        }
        return res;
    }
    public static int xuan2(int[] arr, int aim) {

        int n = arr.length;
        int [][]dp = new int[n+1][aim+1];
        dp[n][0] = 1;
        for (int index = n-1; index >=0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                int res = 0;
                //选的张数，只要小于最终值，我可以一直选。0张 1张。。。。。。
                for (int zhang = 0; arr[index] * zhang <= rest; zhang++) {
                    res += dp[index+1][ rest - (arr[index] * zhang)];
                }
                dp[index][rest] = res;
            }
        }
        return dp[0][aim];
    }

    public static int process(int[] arr,int name){
        int result = 0;
        for(int i = 0;i<arr.length;i++){
            int a = arr[i] % name == 0? arr[i] : 0;
            result = Math.max(a,result);
        }
        return result;
    }
    public static void main(String[] args) {
        /*int[][] m = {{1, 3, 5, 9}, {8, 1, 3, 4}, {5, 0, 6, 1}, {8, 8, 4, 0}};
        System.out.println(process2(m));*/
        /*int[] arr = {1,3,4,5,6};
        System.out.println(xuan(arr,0,6));
        System.out.println(xuan2(arr,6));*/
        /*int[] a = {4,2};
        System.out.println(process(a, 2));*/



    }



}
