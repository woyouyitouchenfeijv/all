package com.algorithm.system;

/**
 * @Description
 * @Date 2023/4/3
 * <p>
 * KMP
 *
 * 2个字符串
 * 字符串1 = aaaab
 * 字符串2 = acbadalaaaabdjqw
 * 字符串1 在字符串2的第几个位置开始可以相等
 *
 * 计算字符串1 每个字符左边的最大前缀 = 最大后缀是什么 - 求next数组
 * 比如 aaaabbc
 * a 左边没值 是 -1
 * a 左边有一个a，没有相等 是 0
 * a 左边有两个a，有相等 是1
 * a 左边有3个a，最大前缀 = 后缀是2 （a a a ）a
 *                              （0 1 2 ）a  01前缀 = 12后缀 所以是2
 * b 左边4个 a，有相等 是3
 * b 左边4个a，1个b，因为后缀多了个b，前缀里没有b所以是0
 * c 是0
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
            //如果两个相等，字符串往后走一位
            if (ch1[x] == ch2[y]) {
                x++;
                y++;
                //走到-1了还在循环，说明没有相等的，所以得x++。在第一个字符串里，再选一个头
            } else if (next[y] == -1) {
                x++;
            } else {
                //如果发现不想等的数，并且没-1，y就挪动前缀数组个位置。
                /**
                 * 到了 一个位置不想等后，这个位置的前缀和
                 * 因为走到了这个位置，所以前面一段一定存着前缀 = 后缀
                 * 这时候为了减少对比，直接把前缀挪到字符1的后缀对齐位置
                 * 所以挪动到后面
                 *
                 * s1 =【i xxxxx j xxxxx N xxxxx】
                 * s2 =【o xxxxx z xxxxx M】
                 *  发现 N！= M
                 *  说明从 i 开始，匹配不出来整个s2
                 *  所以下次应该从 i 的后一位开始算
                 *  但是因为 M 求了前缀和，我们已经知道了 o-z = z-m
                 *  所以 i-j = j-n
                 *  所以 i-j 这一段里面，一定匹配不出 M 结尾的字符串。因为 z 已经在 j-n 这一段了。前缀和已经算过了，z不可能在j-n里
                 *  所以直接挪动，
                 * s1 =【i xxxxx ｜  j xxxxx N xxxxxxxxxxxxxx】
                 * s2 =          ｜【o xxxxx z xxxxx M】
                 * 这样比对，j 开始去找M
                 * 这个时候，又是前缀和，知道了j-n = o-z
                 * 所以这一段也不用比，只用知道 z和 N是否相等，相等继续，不想等，继续往后
                 *
                 * 这就是kmp
                 */
                y = next[y];
            }
        }
        return y == s2.length() ? x - y : -1;


    }

    public static void main(String[] args) {
        String a = "aaaabbc";
        int[] next = getNext(a.toCharArray());
        for (int i = 0; i < next.length; i++) {
            System.out.println(next[i]);
        }
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
