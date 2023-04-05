package com.algorithm.system.class1;

/**
 * @Description
 * @Date 2023/4/2
 *
 * 在一个有序数组中，找某个数是否存在
 */
public class GetNumInArr {

    //普通
    public static boolean getNum1(int[] arr , int ans){
        for (int i : arr) {
            if(i == ans){
                return true;
            }
        }
        return false;
    }

    //二分法
    public static boolean getNum2(int[] arr , int ans){
        if(arr == null || arr.length == 0){
            return false;
        }
        int l = 0;
        int r = arr.length-1;
        int mid = 0;
        while (l<r){
            mid = (l+r)/2;
            if(arr[mid] == ans){
                return true;
            }else if(arr[mid] > ans){
                r = mid -1;
            }else{
                l = mid + 1;
            }
        }
        return arr[mid] == ans;
    }
}
