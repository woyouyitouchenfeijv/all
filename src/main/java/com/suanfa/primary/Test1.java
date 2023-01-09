package com.suanfa.primary;

/**
 * @Description
 * @Date 2022/12/29
 */
public class Test1 {


    /**
     * 算阶乘
     * 1!+2!+3!+.......+N! 算最终值
     *
     *
     * 加的时候，先算1! ,得到一个值，然后算2! 。算的时候，其实是 1! 的值 x 2 就等于 2! 。
     * 因此需要两个变量，一个记录上次的，一个记录累加和
     */

    public static void main(String[] args) {

        int N = 10;

        //最终的和
        int all = 0;
        //中间值
        int mid = 1;
        //因为要排除 0 ，0X任何数都是 0 所以从1开始，并且要<= N。
        for (int i = 1; i <= N; i++) {
            mid = mid * i;
            all = all + mid;
        }
        System.out.println(all);

    }

}
