package com.devil.basic.search;

import com.devil.basic.structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 广度优先遍历
 * 广度优先搜索和深度优先搜索一样,都是对图进行搜索的算法,都是从起点开始顺着边搜索,此时并不知道图的整体结构,直到找到指定节点(即终点)。
 * 在此过程中每走到一个节点,就会判断一次它是否为终点。
 * 广度优先搜索会根据离起点的距离,按照从近到远的顺序对各节点进行搜索。
 * 而深度优先搜索会沿着一条路径不断往下搜索直到不能再继续为止,然后再折返,开始搜索下一条路径。
 * 在广度优先搜索中,有一个保存候补节点的队列,队列的性质就是先进先出,即先进入该队列的候补节点就先进行搜索。
 * 在深度优先搜索中，保存候补节点是栈，栈的性质就是先进后出，即最先进入该栈的候补节点就最后进行搜索。
 *
 * @author Devil
 * @date Created in 2022/3/2 13:48
 */
public class BfsSearch {

    public static List<Integer> search(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll.getLeft() != null) {
                queue.offer(poll.getLeft());
            }
            if (poll.getRight() != null) {
                queue.offer(poll.getRight());
            }
            list.add(poll.getVal());
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
