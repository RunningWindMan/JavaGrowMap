package com.devil.basic.structure.tree;

import java.util.Stack;

/**
 * 给定一个二叉树，计算有几个叶子节点
 *
 * @author Devil
 * @date Created in 2022/3/1 17:08
 */
public class TreeLeaf {
    
    public static int leaf(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftLeaf = leaf(root.left);
        int rightLeaf = leaf(root.right);
        return leftLeaf + rightLeaf;
    }
    
    public static int leaf2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int leafSize = 0;
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (pop.left != null) {
                stack.push(pop.left);
            }
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left == null && pop.right == null) {
                leafSize++;
            }
        }
        return leafSize;
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
        System.out.println(leaf(root));
        System.out.println(leaf2(root));
    }
    
}
