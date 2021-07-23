package com.devil.basic.leetcode.tree;

/**
 * @author Devil
 * @date Created in 2021/7/23 16:06
 */
public class TreeNode {

    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}
