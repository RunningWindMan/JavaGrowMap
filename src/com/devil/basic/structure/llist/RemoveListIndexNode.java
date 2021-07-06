package com.devil.basic.structure.llist;

/**
 * 删除链表倒数指定位置的节点
 *
 * @author Devil
 * @date Created in 2021/7/6 14:07
 */
public class RemoveListIndexNode {

    public static void main(String[] args) {
        Node node6 = new Node(6, null);
        Node node5 = new Node(5, node6);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);

//        Node node = removeIndexOne(node1, 2);
//        node.printNode(node);

        Node anotherNode = removeIndexTwo(node1, 2);
        anotherNode.printNode(anotherNode);

    }

    public static Node removeIndexOne(Node node, int index) {
        if (index == 0 || node.next == null) {
            return node;
        }

        // 反转链表
        Node reverse = ReverseListTest.reverse(node);

        int count = 1;
        Node pre = null;
        Node cur = reverse;
        Node next = cur.next;
        while (next != null && count != index) {
            pre = cur;
            cur = next;
            next = cur.next;
            count++;
        }

        if (count != index) {
            return node;
        } else {
            pre.next = next;
            return ReverseListTest.reverse(reverse);
        }

    }

    public static Node removeIndexTwo(Node node, int index) {
        if (index == 0 || node.next == null) {
            return node;
        }

        Node first = node;
        Node second = node;

        for (int i = 0; i <= index; i++) {
            if (first != null) {
                first = first.next;
            } else {
                return node;
            }
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        return node;
    }

}
