package com.lintcode.coins_in_a_line_2;

public class Solution {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        if (values == null) {
            return false;
        }
        if (values.length <= 2) {
            return true;
        }
        int length = values.length;
        int[] d = new int[length + 4];
        d[length - 1] = values[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            d[i] = values[i] + Math.min(d[i + 1 + 1], d[i + 1 + 2]);
            d[i] = Math.max(d[i], values[i] + values[i + 1] + Math.min(d[i + 2 + 1], d[i + 2 + 2]));
        }
        int sum = 0;
        for (int v : values) {
            sum += v;
        }
        return sum < 2 * d[0];
    }
}