package com.algorithm.system;

/**
 * @Description
 * @Date 2023/2/9
 */
public class Test6 {

    /**
     * 327题
     * 给你一个整数数组nums 以及两个整数lower 和 upper 。
     * 求数组中，值位于范围 [lower, upper] （包含lower和upper）之内的 区间和的个数
     *
     * 1、算出前置和的一个数组
     * 2、算每次在前置和里的[总和 - upper ， 总和 - lower]
     * 3、再归并
     */


    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    /**
     * 快排 3个版本
     * 1、每次一个
     * 2、选最右边的一个数当目标，每次排左右、相等的数组不再排了
     * 3、随机选一个当目标
     * 写一个快排就可以了
     */
    public static void fastSort1(int[] arr,int pre,int ra){
        //选一个数当目标值，选左右边的，既能当右边界，也是一个值
        int r = ra;
        //左边界
        int l = -1;
        //指针
        int pro = pre;
        //当指针没到右边，一直走 相当于 for(int i = 0;i<arr.length;i++)
        while (pro<r+1){
            //指针指向的这个值，小于等于基准值
            if(arr[pro] <= arr[r]){
                //这个值放在左边。所以和左边界的下一个值交换
                swap(arr,l+1,pro);
                //左边界往右动一个，包住刚才的那个值
                l++;
                //指针指向下一个
                pro++;
            }else{
                //只是指针动
                pro++;
            }
        }
    }

    public static void quickSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        //得到中间比好的
        int[] equalE = partition(arr, L, R);
        //左边有序
        process(arr, L, equalE[0] - 1);
        //右边有序
        process(arr, equalE[1] + 1, R);
    }
    public static int[] partition(int[] arr, int L, int R) {
        //左边界
        int lessR = L - 1;
        //右边界
        int moreL = R;
        //从左边界的下一个开始
        int index = L;
        //没超出
        while (index < moreL) {
            if (arr[index] < arr[R]) {
                swap(arr, lessR+1, index);
                lessR++;
                index++;
            } else if (arr[index] > arr[R]) {
                swap(arr, moreL-1, index);
                moreL--;
            } else {
                index++;
            }
        }
        swap(arr, moreL, R);
        return new int[] { lessR + 1, moreL };
    }




    public static void main(String[] args) {
        int [] arr = {4,3,1,6,7,5};
        //fastSort1(arr ,0,arr.length-1);
        quickSort1(arr);
        for (int i : arr) {
            System.out.print(i+"-");
        }
    }






}
