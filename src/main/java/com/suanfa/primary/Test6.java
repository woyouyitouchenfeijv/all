package com.suanfa.primary;

/**
 * @Description
 * @Date 2023/1/3
 */
public class Test6 {

    public static int[] returnRandomArr(int maxLength,int maxValue){
        int arrLength = (int)(Math.random() * maxLength);
        int[] ints = new int[arrLength];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = (int)(Math.random() * maxValue);
        }
        return ints;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            int[] ints = returnRandomArr(5, 5);
            for (int anInt : ints) {
                System.out.print(anInt+",");
            }
            System.out.println();
        }
    }
}
