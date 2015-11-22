package com.lintcode.longest_common_subsequence;

public class Solution {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        if (A == null || A.isEmpty() || B == null || B.isEmpty()) return 0;
        final int[][] dp = new int[A.length()][B.length()];
        for (int i = 0; i < A.length(); i++) {
            dp[i][0] = A.charAt(i) == B.charAt(0) ? 1 : 0;
        }
        for (int i = 0; i < B.length(); i++) {
            dp[0][i] = A.charAt(0) == B.charAt(i) ? 1 : 0;
        }
        for (int i = 1; i < A.length(); i++) {
            for (int j = 1; j < B.length(); j++) {
                if (A.charAt(i) == B.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[A.length() - 1][B.length() - 1];
    }
}