package com.devil.basic.structure.tree;

import java.util.Stack;

/**
 * 二叉树遍历
 *
 * @author Devil
 * @date Created in 2021/7/23 16:43
 */
public class BinaryTreeLoop {

    /**
     * 前序遍历  中  左  右   递归
     */
    public static void preLoop(TreeNode node) {
        if (node == null) {
            return;
        }

        System.out.print(node + " ");
        preLoop(node.left);
        preLoop(node.right);
    }

    /**
     * 前序遍历  中  左  右   非递归
     */
    public static void preLoop2(TreeNode node) {
        if (node == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            TreeNode root = stack.pop();

            // 先压栈右子树
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }

            System.out.print(root + " ");
        }
    }

    /**
     * 中序遍历  左   中  右   递归
     */
    public static void middleLoop(TreeNode node) {
        if (node == null) {
            return;
        }

        middleLoop(node.left);
        System.out.print(node + " ");
        middleLoop(node.right);
    }

    /**
     * 中序遍历  左   中  右   非递归
     */
    public static void middleLoop2(TreeNode node) {
        if (node == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode pop = stack.pop();
                System.out.print(pop + " ");
                node = pop.right;
            }
        }
    }

    /**
     * 后序遍历  左  右  中  递归
     */
    public static void postLoop(TreeNode node) {
        if (node == null) {
            return;
        }

        postLoop(node.left);
        postLoop(node.right);
        System.out.print(node + " ");
    }

    /**
     * 后序遍历  左  右  中  非递归
     */
    public static void postLoop2(TreeNode node) {
        if (node == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        Stack<TreeNode> stack2 = new Stack<>();

        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            stack2.push(pop);
            if (pop.left != null) {
                stack.push(pop.left);
            }
            if (pop.right != null) {
                stack.push(pop.right);
            }
        }
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop() + " ");
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.print("preLoop: ");
        preLoop(root);
        System.out.println();

        System.out.print("preLoop2: ");
        preLoop2(root);
        System.out.println();

        System.out.print("middleLoop: ");
        middleLoop(root);
        System.out.println();

        System.out.print("middleLoop2: ");
        middleLoop2(root);
        System.out.println();

        System.out.print("postLoop: ");
        postLoop(root);
        System.out.println();

        System.out.print("postLoop2: ");
        postLoop2(root);
        System.out.println();
    }

}
