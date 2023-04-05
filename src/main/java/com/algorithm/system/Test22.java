package com.algorithm.system;

/**
 * @Description
 * @Date 2023/3/14
 */
public class Test22 {

    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(Math.pow(5, 2));
    }


    /**
     * 给定3个参数，N，M，K
     * 怪兽有N滴血，等着英雄来砍自己
     * 英雄每一次打击，都会让怪兽流失[0~M]的血量
     * 到底流失多少？每一次在[0~M]上等概率的获得一个值
     * 求K次打击之后，英雄把怪兽砍死的概率
     */

    public static int processCount(int N, int M, int K) {
        if (K == 0) {
            return N <= 0 ? 1 : 0;
        }
        int count = 0;
        for (int i = 0; i <= M; i++) {
            count += processCount(N - i, M, K - 1);
        }
        return count;
    }


    public static double dp2(int N, int M, int K) {
        if (N < 1 || M < 1 || K < 1) {
            return 0;
        }
        double[][] dp = new double[N+1][K+1];
        dp[0][0] = 1;
        for (int dao = 0; dao < dp.length; dao++) {
            dp[dao][0] = Math.pow((M+1),dao);
            for (int hp = 1; hp < dp[0].length; hp++) {
                int count = 0;
                for (int i = 0; i <= M; i++) {
                    if (hp - i >= 0) {
                        count += dp[dao - 1][hp - i];
                    } else {
                        count += (long) Math.pow(M + 1, dao - 1);
                    }
                }
                dp[dao][hp] = count;
            }
            
        }
        return dp[N][K];
    }
}
