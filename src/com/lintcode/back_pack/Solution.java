package com.lintcode.back_pack;

public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        int[] d = new int[m + 1];
        for (int v : A) {
            for (int j = m; j >= 0; j--) {
                if (j >= v) {
                    d[j] = Math.max(d[j - v] + v, d[j]);
                }
            }
        }
        return d[m];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().backPack(11, new int[]{2, 3, 5, 7}));
    }
}