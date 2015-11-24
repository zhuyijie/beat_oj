package com.lintcode.longest_increasing_continuous_subsequence;

public class Solution {
    /**
     * @param A an array of Integer
     * @return an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int asc = 1;
        int desc = 1;
        int max = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                asc = asc + 1;
                desc = 1;
            } else if (A[i] < A[i - 1]) {
                desc = desc + 1;
                asc = 1;
            } else {
                asc = asc + 1;
                desc = desc + 1;
            }
            max = Math.max(max, Math.max(asc, desc));
        }
        return max;
    }

    public static void main(String[] args) {
        int[] question = new int[] {5, 1, 2, 3, 4};
        System.out.println(new Solution().longestIncreasingContinuousSubsequence(question));
    }
}
