package com.devil.basic.structure.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树镜像
 *
 * @author Devil
 * @date Created in 2021/7/23 15:43
 */
public class BinaryTreeMirror {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;

//        TreeNode recursionSolution = recursionSolution(node1);
//        BinaryTreeLoop.preLoop(recursionSolution);

//        TreeNode noRecursionSolution = noRecursionSolution(node1);
//        BinaryTreeLoop.preLoop(noRecursionSolution);

        TreeNode noRecursionSolution2 = noRecursionSolution2(node1);
        BinaryTreeLoop.preLoop(noRecursionSolution2);
    }

    /**
     * 递归解法
     */
    public static TreeNode recursionSolution(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        recursionSolution(node.left);
        recursionSolution(node.right);
        return node;
    }

    /**
     * 非递归解法  队列
     */
    public static TreeNode noRecursionSolution(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            TreeNode head = queue.poll();
            TreeNode left = head.left;
            head.left = head.right;
            head.right = left;

            if (head.left != null) {
                queue.offer(head.left);
            }

            if (head.right != null) {
                queue.offer(head.right);
            }
        }
        return node;
    }

    /**
     * 非递归解法  栈
     */
    public static TreeNode noRecursionSolution2(TreeNode node) {
        if (node == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            TreeNode left = pop.left;
            pop.left = pop.right;
            pop.right = left;
            if (pop.left != null) {
                stack.push(pop.left);
            }
            if (pop.right != null) {
                stack.push(pop.right);
            }
        }
        return node;
    }

}
