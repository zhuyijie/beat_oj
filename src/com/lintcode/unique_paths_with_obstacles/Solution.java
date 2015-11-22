package com.lintcode.unique_paths_with_obstacles;

public class Solution {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int nrow = obstacleGrid.length;
        if (nrow == 0) {
            return 0;
        }
        int ncol = obstacleGrid[0].length;
        int[][] dp = new int[nrow][ncol];
        for (int i = 0;i < nrow;i++) {
            for (int j = 0;j < ncol;j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[nrow - 1][ncol - 1];
    }
}
