package com.algorithm.primary;

/**
 * @Description
 * @Date 2023/1/17
 */
public class Test14 {


    /**
     *  一个数的负数 = 这个数取返 + 1
     *
     */
    public static void main(String[] args) {
        System.out.println( ~1+1);





        int num = 2;
        int[] arr = new int[32];
        for (int i = 31; i >= 0; i--) {
            if((1&num) > 0){
                arr[i]=1;
            }else{
                arr[i]=0;
            }
            num = num >>> 1;
        }
        for (int i : arr) {
            System.out.print(i);
        }
    }
}
