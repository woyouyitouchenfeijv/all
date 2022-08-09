package com.likou;

import org.junit.Test;

/**
 * @Description
 * @Date 2022/8/9
 */
public class Topic1413 {

    public int minStarValue(int[] nums){
        int min = 0,sum  = 0;
        for (int i : nums) {
            //累计相加，和上一步比对，拿到最小的值
            sum = sum+i;
            min = Math.min(min,sum);
        }
        //最小的值加1就是最小整数
        return 1 - min;
    }

    @Test
    public void test(){
        int[] num = {-3,2,-3,4,2};
        System.out.println(minStarValue(num));
    }
}
