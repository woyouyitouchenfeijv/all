package com.algorithm.primary;

/**
 * @Description
 * @Date 2023/1/16
 */
public class Test13 {


    public static class BitMap {

        private static long[] bits;


        public BitMap(int num){
            bits = new long[(num + 64) >> 6];
        }
        public static void add(int num){
            /**
             * num / 64 就知道是在第几个long值上
             * num 和 63 & 。因为63在long里全是1，和他&完等于 num % 63 ，获得num在64里面的第几位
             */
            bits[num >> 6] =bits[num >> 6] | (1L<<(num & 63));
        }
        public static void del(int num){

            /**
             *  拿到第几位，比如第二位 00010
             *  在 或 ，得到  11101
             *  然后 与 11111， 0位置的那个和 原有的1 与完就是 0 ，等于删除了这个数
             */
            bits[num >> 6] = bits[num >> 6]  & (~(1L<<(num & 63)));
        }
        public static boolean get(int num){
            return (bits[num >> 6] & (1L << (num & 63))) != 0;
        }


        public static void main(String[] args) {
            int num = 6;
            BitMap bitMap = new BitMap(12);
            bitMap.add(num);
            System.out.println(bitMap.get(num));
            bitMap.del(num);
            System.out.println(bitMap.get(num));

        }
    }


    public static void main(String[] args) {
        System.out.println(64 >> 6);
        System.out.println(128 >> 6);
    }





}
