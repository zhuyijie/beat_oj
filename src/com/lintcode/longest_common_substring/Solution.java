package com.lintcode.longest_common_substring;

public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        if (A == null || A.isEmpty() || B == null || B.isEmpty()) {
            return 0;
        }
        final int aLength = A.length();
        final int bLength = B.length();
        final int[][] dp = new int[aLength][bLength];
        int max = 0;
        for (int i = 0; i < aLength; i++) {
            dp[i][0] = A.charAt(i) == B.charAt(0) ? 1 : 0;
            max = Math.max(dp[i][0], max);
        }
        for (int i = 0; i < bLength; i++) {
            dp[0][i] = A.charAt(0) == B.charAt(i) ? 1 : 0;
            max = Math.max(dp[0][i], max);
        }

        for (int i = 1; i < aLength; i++) {
            for (int j = 1; j < bLength; j++) {
                if (A.charAt(i) == B.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}