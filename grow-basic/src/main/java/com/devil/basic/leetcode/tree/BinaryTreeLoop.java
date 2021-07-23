package com.devil.basic.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树遍历
 *
 * @author Devil
 * @date Created in 2021/7/23 16:43
 */
public class BinaryTreeLoop {

    /**
     * 前序遍历  左  中  右   递归
     */
    public static void preLoop(TreeNode node) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            preLoop(node.left);
        }

        System.out.print(node + " ");

        if (node.right != null) {
            preLoop(node.right);
        }
    }

    /**
     * 前序遍历  左  中  右   非递归
     */
    public static void preLoop2(TreeNode node) {
        if (node == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        // 如果左子树有值，先左子树入队
        while (node.left != null) {
            node = node.left;
        }


    }

    /**
     * 中序遍历  中  左  右   递归
     */
    public static void middleLoop(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node + " ");

        if (node.left != null) {
            preLoop(node.left);
        }

        if (node.right != null) {
            preLoop(node.right);
        }
    }

    /**
     * 后序遍历  左  右  中  递归
     */
    public static void postLoop(TreeNode node) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            preLoop(node.left);
        }

        if (node.right != null) {
            preLoop(node.right);
        }
        System.out.print(node + " ");
    }

}
