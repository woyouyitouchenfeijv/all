package com.algorithm.primary;

import com.algorithm.SortParent;

/**
 * @Description
 * @Date 2022/12/30
 */
public class Test3 extends SortParent {



    public static void test(int[] arr){
        //循环  0 - n-1
        for (int first = 0; first < arr.length-1; first++) {
            //循环 1-n
            for (int second = 1; second < arr.length; second++) {
                //如果后面的值大于前一个，就交换
                if(arr[second] < arr[second-1] ){
                    swap(arr,second-1,second);
                }
            }
        }
        printlnIntArr(arr);
    }


    public static void main(String[] args) {
        int [] arr = {1,23,45,7,80,1,23,3,69,6,24,5,6,78,9};

        test(arr);


        for (int i : arr) {
            for (int first = 0; first < arr.length-1; first++) {
                int second = first+1;
                if(arr[second] < arr[first] ){
                    swap(arr,first,second);
                }
            }
        }
        printlnIntArr(arr);
    }
}
