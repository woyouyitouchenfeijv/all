package com.algorithm.system;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Date 2023/3/7
 */
public class Test19 {

    /* public static void main(String[] args) {
         int[] w = {3, 2, 4, 7, 3, 1, 7};
         int[] m = {5, 6, 3, 19, 12, 4, 2};
         System.out.println(big(w, m, 0, 15));
     }
 */
    public static int big(int[] w, int[] m, int index, int all) {
        if (all < 0) {
            return -1;
        }
        //越界，最后一个是length - 1
        if (index == w.length) {
            return 0;
        }
        //我不要这个index
        int a = big(w, m, index + 1, all);
        //我要了这个index
        int b = big(w, m, index + 1, all - w[index]);
        if (b != -1) {
            b = b + m[index];
        }
        return Math.max(a, b);
    }


    /**
     * https://leetcode.cn/problems/stickers-to-spell-word/submissions/
     */

    public static int get(char[] num, int index) {
        if (index == num.length) {
            return 1;
        }
        if (num[index] == '0') {
            return 0;
        }

        //这个位置单独转换
        int a = get(num, index + 1);
        //这个位置不转
        if (index + 1 < num.length && (num[index] - '0') * 10 + num[index + 1] - '0' < 27) {
            a = a + get(num, index + 2);
        }
        return a;
    }

    public int minStickers(String[] stickers, String target) {
        Map<String, Integer> dp = new HashMap<>();
        int a = getSet(stickers, target, dp);

        return a == Integer.MAX_VALUE ? -1 : a;
    }

    public static int getSet(String[] stickers, String target, Map<String, Integer> dp) {
        if (dp.get(target) != null) {
            return dp.get(target);
        }
        if (target.length() == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (String first : stickers) {
            String rest = remove(target, first);
            if (rest.length() != target.length()) {
                min = Math.min(min, getSet(stickers, rest, dp));
            }
        }
        min = min + (min == Integer.MAX_VALUE ? 0 : 1);
        dp.put(target, min);
        return min;
    }

    public static String remove(String old, String target) {
        char[] chars1 = old.toCharArray();
        char[] chars2 = target.toCharArray();
        //26个字母的位置
        int[] count = new int[26];
        //遍历第一个char1，看每个字母出现的次数
        for (int i = 0; i < chars1.length; i++) {
            //算出这个char是谁，a是0位置，所以减完后，是几就在几位置
            int ct = chars1[i] - 'a';
            //这个位置的count+1
            count[ct] = count[ct] + 1;
        }
        for (char cha : chars2) {
            count[cha - 'a']--;
        }
        StringBuilder a = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                for (int j = 0; j < count[i]; j++) {
                    a.append((char) (i + 'a'));
                }
            }
        }
        return a.toString();
    }


    public int minStickers2(String[] stickers, String target) {
        Map<String, Integer> dp = new HashMap<>();

        int[][] stickerArr = new int[stickers.length][26];

        for (int i = 0; i < stickers.length; i++) {
            char[] chars = stickers[i].toCharArray();
            for (char aChar : chars) {
                stickerArr[i][aChar-'a']++;
            }
        }


        int a = getSet2(stickerArr, target, dp);

        return a == Integer.MAX_VALUE ? -1 : a;
    }

    public static int getSet2(int[][] stickers, String t, Map<String, Integer> dp) {
        if (dp.get(t) != null) {
            return dp.get(t);
        }
        if (t.length() == 0) {
            return 0;
        }

        char[] target = t.toCharArray();
        int[] tcounts = new int[26];
        for (char cha : target) {
            tcounts[cha - 'a']++;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < stickers.length; i++) {
            int[] sticker = stickers[i];
            //target[0]  - 拿到第一个字符串
            //sticker[target[0] - 'a'] > 0 判断字符串是否在 sticker 数组里面
            //如果一直没有，就表示不可能拼出来
            //如果有，先匹配这个，然后下次target变了，0也就变了
            if (sticker[target[0] - 'a'] > 0) {
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < 26; j++) {
                    if (tcounts[j] > 0) {
                        int nums = tcounts[j] - sticker[j];
                        for (int k = 0; k < nums; k++) {
                            builder.append((char) (j + 'a'));
                        }
                    }
                }
                String rest = builder.toString();
                min = Math.min(min, getSet2(stickers, rest,dp));
            }
        }
        min = min + (min == Integer.MAX_VALUE ? 0 : 1);
        dp.put(t, min);
        return min;
    }

    public static String remove2(String old, String target) {
        char[] chars1 = old.toCharArray();
        char[] chars2 = target.toCharArray();
        //26个字母的位置
        int[] count = new int[26];
        //遍历第一个char1，看每个字母出现的次数
        for (int i = 0; i < chars1.length; i++) {
            //算出这个char是谁，a是0位置，所以减完后，是几就在几位置
            int ct = chars1[i] - 'a';
            //这个位置的count+1
            count[ct] = count[ct] + 1;
        }
        for (char cha : chars2) {
            count[cha - 'a']--;
        }
        StringBuilder a = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                for (int j = 0; j < count[i]; j++) {
                    a.append((char) (i + 'a'));
                }
            }
        }
        return a.toString();
    }




    public static void main(String[] args) {
        //System.out.println(get("2132082".toCharArray(), 0));
        System.out.println(remove("aabasda", "aa"));
    }


}
