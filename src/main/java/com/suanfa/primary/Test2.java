package com.suanfa.primary;

/**
 * @Description
 * @Date 2022/12/30
 *
 *
 * 选择排序，选一个数字做为最小数字。然后放在0位置。
 * 一直循环直到排序好
 */
public class Test2 {




    public static void main(String[] args) {

        //因此需要2层循环
        int [] arr = {1,23,45,7,80,1,23,3,69,6,24,5,6,78,9};
        for(int i = 0 ;i<arr.length;i++){
            int min = i;
            //比对拿到最小值
            for(int j = i+1 ; j < arr.length ; j++){
               min =  arr[j] < arr[min] ? j : min;
            }
            //去掉不必要的转换
            if(min != i){
                int c = arr[i];
                arr[i] = arr[min];
                arr[min] = c;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+",");
        }

    }
}
