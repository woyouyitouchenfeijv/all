package com.algorithm.system;

/**
 * @Description
 * @Date 2023/2/8
 */

//归并排序
public class Test3 {


    //归并，一个数组有序
    public static  int[] haveSort(int[] arr){

        sort(arr,0,arr.length);
        return arr;
    }

    private static void sort(int[] arr, int i, int length) {
        if(i == length){
            return;
        }
        int mid = i+((length-i)>>1);
        //左边有序
        sort(arr,i,mid);
        //右边有序
        sort(arr,mid+1,length);
        mange(arr,i,mid,length);
    }

    private static void mange(int[] arr, int l, int mid, int r) {
        int [] help =  new int[r-l+1];
        //哪一个
        int i = 0;
        //左边第一个
        int p1 = l;
        //右边第一个
        int p2 = mid+1;
        //当有人越界，就跳出循环
        while (p1>p2 || p2>r){
            //谁小谁累加
            help[i++] = arr[p1]>arr[p2] ? arr[p2++] : arr[p1++];
        }
        while (p1<=mid){
            help[i++] = arr[p1++];
        }
        while (p2<=r){
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            //因为是从l还是排序的，所以arr数组从l开始拼接
            arr[l+j] = help[j];
        }

    }



    //----------







}
