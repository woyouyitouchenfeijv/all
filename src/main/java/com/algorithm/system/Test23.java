package com.algorithm.system;

/**
 * @Description
 * @Date 2023/3/16
 */
public class Test23 {
    /**
     * 给定一个正数数组arr，请把arr中所有的数分成两个集合
     * 如果arr长度为偶数，两个集合包含数的个数要一样多
     * 如果arr长度为奇数，两个集合包含数的个数必须只差一个
     * 请尽量让两个集合的累加和接近
     * 返回：
     * 最接近的情况下，较小集合的累加和
     */


    public static int process(int[] arr, int index, int count, int result) {
        int length = arr.length;
        if (index == length) {
            return count == 0 ? 0 : -1;
        } else {
            //不用index
            int p1 = process(arr,index+1,count-1,result);
            //用index
            int p2 = -1;
            if(result >= arr[index] ){
                p2 = process(arr,index+1,count-1,result-arr[index]);
            }
            if(p2 != -1){
                p2  = p2+arr[index];
            }
            return Math.max(p1,p2);
        }
    }


    /**
     * n皇后
     */
}
