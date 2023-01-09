package com.suanfa.primary;

/**
 * @Description
 * @Date 2023/1/3
 */
public class Test5 {

    public static void main(String[] args) {
        int k = 5;
        int count = 0;
        for (int i = 0; i < 100000; i++) {
            if(((int) (Math.random() * 5))<3){
                count ++;
            }

        }
        System.out.println((double)(count/100000));
        for (int i = 0; i < 100; i++) {

            System.out.println((int) (Math.random() * 5));
        }


        /**
         * Math.random() 得到的是一个 【0-1）里的数字，并且0-1中的每个数字出现概率相同。包含0 不包含1
         */

    }
}
