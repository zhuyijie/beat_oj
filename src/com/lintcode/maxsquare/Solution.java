package com.lintcode.maxsquare;

/**
 * Created by yijiezhu on 15-11-21.
 */
public class Solution {
    /**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
    public int maxSquare(int[][] matrix) {
        if (matrix == null) {
            return 0;
        }
        int nrow = matrix.length;
        if (nrow == 0) {
            return 0;
        }
        int ncol = matrix[0].length;
        int[][] dp = new int[nrow][ncol];
        int max = 0;
        for (int i = 0; i < nrow; i++) {
            for (int j = 0; j< ncol; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j];
                } else if (matrix[i][j] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
                max = Math.max(dp[i][j], max);
            }
        }
        return max * max;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1, 0, 1, 0, 0},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0}
        };
        System.out.println(new Solution().maxSquare(matrix));
    }
}
