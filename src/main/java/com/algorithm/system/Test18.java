package com.algorithm.system;

/**
 * @Description
 * @Date 2023/3/3
 */
public class Test18 {

    //机器步数
    //1 2 3 4 5 6 7
    public static int a(int cur, int rest, int aim, int n) {
        if (rest == 0) {
            return cur == aim ? 1 : 0;
        }
        if (cur == 1) {
            return a(2, rest - 1, aim, n);
        }
        if (cur == n) {
            return a(n - 1, rest - 1, aim, n);
        }
        return a(cur + 1, rest - 1, aim, n) + a(cur - 1, rest - 1, aim, n);
    }


    public static void main(String[] args) {
        //System.out.println(a(2, 4, 4, 4));

        int[] arr = {5, 7, 4, 5, 8, 1, 6, 0, 3, 4, 6, 1, 7};
        int f = f(arr, 0, arr.length - 1);
        int g = g(arr, 0, arr.length - 1);
        System.out.println(Math.max(f, g));
        win1(arr);
        win2(arr);
    }


    /**
     * 选手挑牌 只能从两头选一张，最终先选的总和大还是后选的总和大
     */
    //先手
    public static int f(int[] arr, int l, int r) {
        if (l == r) {
            return arr[l];
        }
        //先选左
        int lFirst = arr[l] + g(arr, l + 1, r);
        //先选右
        int rFirst = arr[r] + g(arr, l, r - 1);
        return Math.max(lFirst, rFirst);

    }

    //后手
    public static int g(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        //别人先选走了l
        int a = f(arr, l + 1, r);
        //别人先选走了r
        int b = f(arr, l, r - 1);
        return Math.min(a, b);
    }


    /**
     * 只加缓存版本
     */

    public static void win1(int[] arr) {
        int length = arr.length;
        int[][] fmap = new int[length][length];
        int[][] gmap = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                fmap[i][j] = -1;
                gmap[i][j] = -1;
            }
        }
        int f = f1(arr, 0, arr.length - 1, fmap);
        int g = g1(arr, 0, arr.length - 1, gmap);
        System.out.println(Math.max(f, g));
    }

    //先手
    public static int f1(int[] arr, int l, int r, int[][] fmap) {
        int ans = 0;
        if (fmap[l][r] != -1) {
            return fmap[l][r];
        }
        if (l == r) {
            ans = arr[l];
            fmap[l][r] = ans;
            return ans;
        }
        //先选左
        int lFirst = arr[l] + g1(arr, l + 1, r, fmap);
        //先选右
        int rFirst = arr[r] + g1(arr, l, r - 1, fmap);
        ans = Math.max(lFirst, rFirst);
        fmap[l][r] = ans;
        return ans;

    }

    //后手
    public static int g1(int[] arr, int l, int r, int[][] gmap) {
        int ans = 0;
        if (gmap[l][r] != -1) {
            return gmap[l][r];
        }

        if (l == r) {
            gmap[l][r] = 0;
            return 0;
        }
        //别人先选走了l
        int a = f1(arr, l + 1, r, gmap);
        //别人先选走了r
        int b = f1(arr, l, r - 1, gmap);
        ans = Math.min(a, b);
        gmap[l][r] = ans;
        return ans;
    }


    /**
     * 动态规划
     */
    public static void win2(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println(0);
            return;
        }

        int length = arr.length;
        int[][] fmap = new int[length][length];
        int[][] gmap = new int[length][length];
        //对角都是自己
        for (int i = 0; i < length; i++) {
            fmap[i][i] = arr[i];
        }
        //0-0对角已经有了，所以从1开始
        for (int i = 1; i < length; i++) {
            //行
            int row = 0;
            //列
            int col = i;
            while (col < length) {
                fmap[row][col] = Math.max(arr[row] + gmap[row + 1][col], arr[col] + gmap[row][col - 1]);
                gmap[row][col] = Math.min(fmap[row + 1][col], fmap[row][col - 1]);
                row++;
                col++;
            }
        }
        int ans = Math.max(fmap[0][length-1], gmap[0][length-1]);
        System.out.println(ans);
        return;


    }
}
