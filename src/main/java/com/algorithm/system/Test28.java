package com.algorithm.system;

/**
 * @Description
 * @Date 2023/4/10
 *
 * 最大回文
 */
public class Test28 {

    /**
     * 给一个数组，返回最大回文长度
     */
    public static int manacher(String s){
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = getChar(s);
        // 每个数的回文半径的大小
        int[] pArr = new int[str.length];
        int C = -1;
        int R = 0;
        int max = 0;
        for (int i = 0; i < str.length; i++) {
            /**
             *
             * 第一种， i 在 R 外面，暴力查
             * 第二种，i在R内
             *      2.1 i的回文字符串，也在R内，直接得到答案
             *      2.2 i的回文字符串，和边界R相等，需要再往外比对，拿到答案
             *      2.3 i的回文字符串，在R外面，需要比对，拿大答案
             */

            // R第一个违规的位置，i>= R
            // i位置扩出来的答案，i位置扩的区域，至少是多大。
            pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;
            while (i + pArr[i] < str.length && i - pArr[i] > -1) {
                if (str[i + pArr[i]] == str[i - pArr[i]])
                    pArr[i]++;
                else {
                    break;
                }
            }
            if (i + pArr[i] > R) {
                R = i + pArr[i];
                C = i;
            }
            max = Math.max(max, pArr[i]);
        }
        return max-1;
    }
    //给数组加 #
    public static char[] getChar(String str){
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i != res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }

    // for test
    public static int right(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = getChar(s);
        int max = 0;
        for (int i = 0; i < str.length; i++) {
            int L = i - 1;
            int R = i + 1;
            while (L >= 0 && R < str.length && str[L] == str[R]) {
                L--;
                R++;
            }
            max = Math.max(max, R - L - 1);
        }
        return max / 2;
    }

    // for test
    public static String getRandomString(int possibilities, int size) {
        char[] ans = new char[(int) (Math.random() * size) + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (char) ((int) (Math.random() * possibilities) + 'a');
        }
        return String.valueOf(ans);
    }

    public static void main(String[] args) {
        int possibilities = 5;
        int strSize = 20;
        int testTimes = 5000000;
        System.out.println("test begin");
        for (int i = 0; i < testTimes; i++) {
            String str = getRandomString(possibilities, strSize);
            if (manacher(str) != right(str)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("test finish");
    }

}
