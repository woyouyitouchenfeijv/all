package com.algorithm.primary;

import java.io.IOException;

/**
 * @Description
 * @Date 2023/2/2
 */
public class Test23 {



    public static void prass(int[] arr , int L ,int R){
        if(L == R){
            return;
        }
        int mid =(L+R)/2;
        prass(arr,L,mid);
        prass(arr,mid+1,R);
        marage(arr,L,mid,R);
    }

    private static void marage(int[] arr, int l, int mid, int r) {
        int [] help = new int[r-l+1];
        int i = 0;
        int p1 = l;
        int p2 = mid+1;
        while (p1<=mid && p2 <= r){
            //i++ 是用完再 ++ 所以  第一次是0
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        //最终，有一个每越界
        while (p1<=mid){
            help[i++] = arr[p1++];
        }
        while (p2<=r){
            help[i++] = arr[p2++];
        }
        //赋值
        for (int j = 0; j < help.length; j++) {
            arr[l+j] = help[j];
        }
        for (int c : arr) {
            System.out.print(c);
        }
        System.out.println("====");
    }

    public static void main(String[] args) throws Exception{
        int [] arr = new int[]{9,8,7,6,5,4,3,2};
        prass(arr,0,arr.length-1);
        for (int i : arr) {
            System.out.print(i);
        }
        while (true){
            Thread.sleep(10000000l);
        }
    }


    static class a{

        public static void main(String[] args) throws IOException {
            Process exec = Runtime.getRuntime().exec("tail -f aaa.txt");
            int i = exec.exitValue();
            System.out.println(i);
        }



    }
}
