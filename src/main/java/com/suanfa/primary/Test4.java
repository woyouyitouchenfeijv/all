package com.suanfa.primary;

import com.suanfa.SortParent;

/**
 * @Description
 * @Date 2022/12/30
 */
public class Test4 extends SortParent {


    public static void main(String[] args) {
        int [] arr = {51,23,45,7,80,1,23,3,69,6,24,5,6,78,9};
        //先拿到要插入的数
        for (int i = 1; i < arr.length; i++) {
            //第二个循环是拿到之前的所有，和i去比对，如果比i小就交换。直到前面没有数字，或者每个人都比他小
            for (int num = i-1;num>=0 && arr[num] > arr[num+1]; num--) {
                swap(arr,num,num+1);
            }
        }
        printlnIntArr(arr);

    }
}
