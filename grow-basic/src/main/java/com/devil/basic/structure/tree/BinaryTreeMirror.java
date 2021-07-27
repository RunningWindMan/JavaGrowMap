package com.devil.basic.structure.tree;

import java.util.LinkedList;
import java.util.Queue;

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

//        BinaryTreeLoop.preLoop(node1);
        BinaryTreeLoop.preLoop2(node1);
        System.out.println();

//        TreeNode recursionSolution = recursionSolution(node1);
//        BinaryTreeLoop.preLoop(recursionSolution);

//        TreeNode noRecursionSolution = noRecursionSolution(node1);
//        BinaryTreeLoop.preLoop(noRecursionSolution);
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
     * 非递归解法
     */
    public static TreeNode noRecursionSolution(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
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

}
