package com.algorithm.system.class1;

/**
 * @Description
 * @Date 2023/2/7
 */
public class Test1 {









    public int getKNum(int[] arr , int k , int m){
        int[] ints = new int[32];
        for (int anInt : ints) {

            //拿到这个数，然后看他的二进制每一位是否是1 ，是1 就累加
            for (int i = 0; i < 32; i++) {
                if( ((anInt >> i) & 1) != 0){
                    ints[i]++;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            //因为其他数都是出现了 m 次，所以二进制这个位上的数，除去m 如果不为0，那就说明 k次的数加进来了。k次出现的数，在这里就是 1
            if(ints[i] % m != 0){
                result = (1<<i) | result;
            }
        }
        return result;
    }


    public static void main(String[] args) {








    }

}
