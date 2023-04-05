package com.algorithm.system;

import java.util.LinkedList;

/**
 * @Description
 * @Date 2023/3/20
 */
public class Test24 {
    //对数器

    public static int[] baoli(int[] arr, int w) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int N = arr.length;

        int[] res = new int[N - w + 1];

        int l = 0;
        int r = w - 1;
        int index = 0;
        while (r < N) {
            int max = arr[l];
            for (int i = l + 1; i <= r; i++) {
                max = Math.max(max, arr[i]);
            }
            res[index] = max;
            index++;
            l++;
            r++;
        }
        return res;
    }


    public static int[] porcess1(int[] arr, int w) {
        if (arr == null || arr.length == 0 || !(w > 0)) {
            return null;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int r = 0; r < arr.length; r++) {
            while (!queue.isEmpty() && arr[queue.getLast()] <= arr[r]) {
                queue.pollLast();
            }
            queue.addLast(r);
            if (queue.getFirst() == r - w) {
                queue.pollFirst();
            }
            if (r >= w - 1) {
                res[index++] = arr[queue.getFirst()];
            }
        }
        return res;
    }


    public static int process3(int[] arr, int sum) {
        if (arr == null || arr.length == 0 || !(sum > 0)) {
            return 0;
        }
        int res = 0;
        int N = arr.length;
        LinkedList<Integer> min = new LinkedList<>();
        LinkedList<Integer> max = new LinkedList<>();
        int R = 0;
        for (int L = 0; L < N; L++) {
            while (R < N) {
                while (!max.isEmpty() && arr[max.getLast()] <= arr[R]) {
                    max.pollLast();
                }
                max.addLast(R);
                while (!min.isEmpty() && arr[min.getLast()] >= arr[R]) {
                    min.pollLast();
                }
                min.addLast(R);
                if (arr[max.getFirst()] - arr[min.getFirst()] <= sum) {
                    R++;
                } else {
                    break;
                }
            }
            res += R - L;
            if (max.getFirst() == L) {
                max.pollFirst();
            }
            if (min.getFirst() == L) {
                min.pollFirst();
            }

        }

        return res;
    }

    // 暴力的对数器方法
    public static int right3(int[] arr, int sum) {
        if (arr == null || arr.length == 0 || sum < 0) {
            return 0;
        }
        int N = arr.length;
        int count = 0;
        for (int L = 0; L < N; L++) {
            for (int R = L; R < N; R++) {
                int max = arr[L];
                int min = arr[L];
                for (int i = L + 1; i <= R; i++) {
                    max = Math.max(max, arr[i]);
                    min = Math.min(min, arr[i]);
                }
                if (max - min <= sum) {
                    count++;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 4, 3, 3, 6, 7};
        System.out.println(right3(arr, 3));
        System.out.println(process3(arr, 3));
    }
}
