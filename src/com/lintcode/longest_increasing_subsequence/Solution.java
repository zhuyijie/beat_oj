package com.lintcode.longest_increasing_subsequence;

public class Solution {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        final int[] len = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int prefixLen = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] <= nums[i]) {
                    prefixLen = Math.max(prefixLen, len[j]);
                }
            }
            len[i] = prefixLen + 1;
            max = Math.max(len[i], max);
        }
        return max;
    }
}