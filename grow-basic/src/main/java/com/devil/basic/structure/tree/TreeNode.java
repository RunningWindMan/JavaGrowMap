package com.devil.basic.structure.tree;

/**
 * 二叉树节点
 *
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

    /**
     * @return the val
     */
    public int getVal() {
        return val;
    }

    /**
     * @param val : the val to set
     */
    public void setVal(int val) {
        this.val = val;
    }

    /**
     * @return the left
     */
    public TreeNode getLeft() {
        return left;
    }

    /**
     * @param left : the left to set
     */
    public void setLeft(TreeNode left) {
        this.left = left;
    }

    /**
     * @return the right
     */
    public TreeNode getRight() {
        return right;
    }

    /**
     * @param right : the right to set
     */
    public void setRight(TreeNode right) {
        this.right = right;
    }
}
