package com.algorithm.primary;

/**
 * @Description
 * @Date 2023/2/2
 */
public class Test25 {


    /**
     * 选择最后一个数
     *
     * 然后这个数相等的在中间，大于在右边，小于在左边
     * 循环完成排序
     */
    public static void process(int[] arr){
        if(arr == null){
            return;
        }
        partition(arr,0,arr.length);
    }

    private static void partition(int[] arr, int L, int R) {



    }


    public static void main(String[] args) {
        System.out.println(128>>1);
    }
}
