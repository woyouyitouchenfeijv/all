package com.suanfa;

/**
 * @Description
 * @Date 2022/12/30
 */
public class SortParent {

    public static void swap(int[] arr , int i,int j){
        if( i == j){
            return;
        }
        int mod = arr[i];
        arr[i] = arr[j];
        arr[j] = mod;
    }

    public static void printlnIntArr(int[] arr){
        System.out.print("{");
        for (int i : arr) {
            System.out.print(i+",");
        }
        System.out.print("}");
        System.out.println();
    }

    public static int[] returnRandomArr(int maxLength,int maxValue){
        int arrLength = (int)(Math.random() * maxLength);
        int[] ints = new int[arrLength];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = (int)(Math.random() * maxValue);
        }
        return ints;
    }
}
