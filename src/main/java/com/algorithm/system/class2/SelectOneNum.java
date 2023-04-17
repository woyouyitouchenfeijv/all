package com.algorithm.system.class2;

/**
 * @Description
 * @Date 2023/4/13
 */
public class SelectOneNum {


    /**
     * 一堆数字，其他数字都是出现偶数个，只有一个数出现奇数个
     *
     * 用 N^N = 0的方式，让奇数个都去掉，留下的就是那个出现奇数个的
     */

    public static void printOddTimesNum2(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        // eor最右侧的1，提取出来
        int rightOne = eor & (-eor); // 提取出最右的1
        int onlyOne = 0; // eor'
        for (int i = 0 ; i < arr.length;i++) {
            if ((arr[i] & rightOne) != 0) {
                onlyOne ^= arr[i];
            }
        }
        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }

    public static void main(String[] args) {
        int eor = 4^8;
        int rightOne = eor & (-eor); // 提取出最右的1
        System.out.println(rightOne);
        System.out.println(rightOne^eor);
    }





}
