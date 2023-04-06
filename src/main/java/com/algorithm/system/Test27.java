package com.algorithm.system;

/**
 * @Description
 * @Date 2023/4/3
 * <p>
 * KMP
 */
public class Test27 {


    //两个数组s1 和 s2，s2在s1里的第几个位置
    public static int process(String s1, String s2) {
        if (s1 == null || s2 == null || s2.length() > s1.length() || s2.length() == 0) {
            return -1;
        }
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        int[] next = getNext(ch2);
        int x = 0;
        int y = 0;
        while (y < s2.length() && x < s1.length()) {
            if (ch1[x] == ch2[y]) {
                x++;
                y++;
            } else if (next[y] == -1) {
                x++;
            } else {
                y = next[y];
            }
        }
        return y == s2.length() ? x - y : -1;


    }

    private static int[] getNext(char[] ch2) {
        int[]next = new int[ch2.length];
        next[0] = -1;
        if(ch2.length == 1){
            return next;
        }
        next[1] = 0;
        int index = 2;
        int cn = 0;
        while (index < next.length){
            if(ch2[index-1] == ch2[cn]){
                cn = cn+1;
                next[index] = cn;
                index++;
            }else if(cn>0){
                cn = next[cn];
            }else{
                next[index] = 0;
                index++;
            }
        }
        return next;
    }

    private static int[] getNext2(char[] ch2) {
        int[]next = new int[ch2.length];
        next[0] = -1;
        if(ch2.length == 1){
            return next;
        }
        next[1] = 0;
        int index = 2;
        int cn = 0;
        while (index < next.length){
            if(ch2[index-1] == ch2[cn]){
                next[index++] = ++cn;
            }else if(cn>0){
                cn = next[cn];
            }else{
                next[index++] = 0;
            }
        }
        return next;
    }
}
