package com.likou;

/**
 * @Description
 * @Date 2023/3/30
 */
public class TestKS {
    public static void main(String[] args) {
        System.out.println(findTheLongestBalancedSubstring1("1111"));


        System.out.println("123".matches(".*3{2}.*"));
    }


    /**
     * 给你一个仅由 0 和 1 组成的二进制字符串 s 。
     *
     * 如果子字符串中 所有的 0 都在 1 之前 且其中 0 的数量等于 1 的数量，则认为 s 的这个子字符串是平衡子字符串。请注意，空子字符串也视作平衡子字符串。
     *
     * 返回  s 中最长的平衡子字符串长度。
     *
     * 子字符串是字符串中的一个连续字符序列。
     */
    public static int findTheLongestBalancedSubstring1(String s) {
        for (int i = s.length() / 2; i > 0; i--) {
            if (s.matches(".*0{" + i + "}1{" + i + "}.*")) {
                return 2 * i;
            }
        }
        return 0;
    }
    public int findTheLongestBalancedSubstring2(String s) {
        char[] cs = s.toCharArray();
        int best = 0;
        for(int i = 0; i < cs.length; i++) {
            //因为0排在1前面
            if(cs[i] == '1') {
                continue;
            }
            int c0 = 0;
            int c1 = 0;
            int j = i;
            //0的个数
            while(j < cs.length && cs[j] == '0') {
                j++;
                c0++;
            }
            //1的个数
            while(j < cs.length && cs[j] == '1') {
                j++;
                c1++;
            }
            i = j - 1;
            best = Math.max(best, Math.min(c0, c1) * 2);
        }
        return best;
    }


    public static int findTheLongestBalancedSubstring3(String s){
        char[] chars = s.toCharArray();
        int ans = 0;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == '1'){
                continue;
            }
            int ans_0 = 0;
            int ans_1 = 0;
            int j = i;
            while (j<s.length() && chars[j]=='0'){
                ans_0++;
                j++;
            }
            while (j<s.length() && chars[j] == '1'){
                ans_1++;
                j++;
            }
            i = j - 1;
            ans = Math.max(ans,Math.min(ans_0,ans_1)*2);
        }
        return ans;
    }



    static class Solution {

        public static void main(String[] args) {
            int[] reward1 = {1,1,3,4}; int[] reward2 = {4,4,1,1};int k = 2;
            int i = miceAndCheese(reward1, reward2, 2);
            System.out.println(i);
        }

        public static int miceAndCheese(int[] reward1, int[] reward2, int k) {

            int ans = 0;
            if (k == 0){
                for (int i : reward2) {
                    ans += reward2[i];
                }
                return ans;
            }
            int index = 0;
            ans = process(reward1,reward2,index,k,ans);
            return ans;
        }

        private static int process(int[] reward1, int[] reward2, int chi, int k, int ans) {
            if(k == 0 || chi >=reward1.length){
                return 0;
            }
            int a = process(reward1,reward2,chi++,k-1,ans+reward1[chi]);
            int b = process(reward1,reward2,chi++,k,ans);
            return Math.max(a,b);
        }
    }


    /**
     *[1,1,3,4]
     * 4,4,1,1
     *
     *
     *
     *  1 4 1 1
     *  4 1 1 1
     *  4 4 3 1
     *  4 4 1 4
     */





}
