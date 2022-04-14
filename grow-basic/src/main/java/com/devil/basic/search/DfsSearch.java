package com.devil.basic.search;

import com.devil.basic.structure.tree.TreeNode;

import java.util.*;

/**
 * 深度优先遍历
 *
 * @author Devil
 * @date Created in 2022/3/2 13:47
 */
public class DfsSearch {
    
    public static List<Integer> search(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (pop.getRight() != null) {
                stack.push(pop.getRight());
            }
            if (pop.getLeft() != null) {
                stack.push(pop.getLeft());
            }
            list.add(pop.getVal());
        }
        return list;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(3));
        root.getLeft().setLeft(new TreeNode(4));
        root.getLeft().setRight(new TreeNode(5));
        root.getRight().setLeft(new TreeNode(6));
        root.getRight().setRight(new TreeNode(7));
        List<Integer> result = search(root);
        result.forEach(System.out::println);
    }
    
}
