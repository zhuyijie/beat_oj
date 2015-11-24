package com.lintcode.climb_stairs;

public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        int a0 = 1, a1 = 1;
        for (int i = 2; i <= n; i++) {
            int tmp = a0;
            a0 = a1;
            a1 = tmp + a1;
        }
        return a1;
    }
}