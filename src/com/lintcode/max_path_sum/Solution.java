package com.lintcode.max_path_sum;

import java.util.concurrent.atomic.AtomicInteger;

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxPathSum(TreeNode root) {
        AtomicInteger max = new AtomicInteger(Integer.MIN_VALUE);
        findMaxRecursive(root, max);
        return max.get();
    }

    private int findMaxRecursive(TreeNode root, AtomicInteger max) {
        if (root == null) {
            return 0;
        }
        int left = findMaxRecursive(root.left, max);
        int right = findMaxRecursive(root.right, max);
        int current = Math.max(Math.max(left + root.val, right + root.val), root.val);
        int currentMax = Math.max(current, root.val + left + right);
        if (currentMax > max.get()) {
            max.set(currentMax);
        }
        return current;
    }
}