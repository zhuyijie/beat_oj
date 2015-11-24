package com.lintcode.minimum_total;

public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(int[][] triangle) {
        int height = triangle.length;
        int[] v = new int[height];
        System.arraycopy(triangle[height - 1], 0, v, 0, height);
        for (int i = height - 2; i >= 0; i--) {
            int[] row = triangle[i];
            for (int j = 0; j < row.length; j++) {
                v[j] = Math.min(v[j], v[j + 1]) + row[j];
            }
        }
        return v[0];
    }
}