package com.lintcode.back_pack_2;

public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A  & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int V[]) {
        if (A == null || V == null || A.length != V.length || m <= 0) {
            return 0;
        }
        int[] d = new int[m + 1];
        for (int i = 0; i < A.length; i++) {
            for (int j = m; j > 0; j--) {
                if (j >= A[i]) {
                    d[j] = Math.max(d[j], d[j - A[i]] + V[i]);
                }
            }
        }
        return d[m];
    }
}