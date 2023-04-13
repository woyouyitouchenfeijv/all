package com.algorithm.system;

/**
 * @Description
 * @Date 2023/4/12
 */
public class Test29 {


    /**
     * 无序数组中的第K小值
     */

    public static void swap(int[] arr, int i1, int i2) {
        int tmp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = tmp;
    }

    //荷兰国旗
    public static int[] partition(int[] arr, int L, int R, int pivot) {
        int mL = L-1;//左边界
        int mR = R +1;//右边界
        int index = mL;//指针，从左开始
        while (index < mR){//指针每越界，继续
            if(arr[index] < pivot){
                swap(arr,index++,++mL);
            }else if(arr[index] > pivot){
                swap(arr,index,--mR);//指针不变，大的那个数变过来到指针，再比一次
            }else{
                index++;
            }
        }
        return new int[]{mL+1,mR-1};
    }





    /**
     * bfprt算法
     */


}
