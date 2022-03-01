package com.devil.basic.structure.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，计算树高
 *
 * @author Devil
 * @date Created in 2022/3/1 16:28
 */
public class TreeDepth {

    public static int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static int depth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int maxDepth = 0;
        while (!queue.isEmpty()) {
            int stackSize = queue.size();
            maxDepth++;
            while (stackSize > 0) {
                TreeNode pop = queue.poll();
                if (pop.left != null) {
                    queue.offer(pop.left);
                }
                if (pop.right != null) {
                    queue.offer(pop.right);
                }
                stackSize--;
            }
        }
        return maxDepth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(8);
        System.out.println(depth(root));
        System.out.println(depth2(root));
    }

}
