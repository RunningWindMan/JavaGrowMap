package com.devil.basic.structure.llist;

/**
 * 单链表反转
 *
 * @author Devil
 * @date Created in 2021/7/6 11:15
 */
public class ReverseListTest {

    public static void main(String[] args) {
        Node node4 = new Node(4, null);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);

        print(node1);

        Node reverseNode1 = reverse(node1);
        print(reverseNode1);

    }

    public static void print(Node node) {
        if (node == null) {
            return;
        }

        Node cur = node;
        StringBuilder s = new StringBuilder();
        while (cur != null) {
            s.append(cur.data);
            s.append(" -> ");
            cur = cur.next;
        }
        s.append("null");
        System.out.println(s);
    }

    public static Node reverse(Node node) {
        if (node == null) {
            return null;
        }

        Node pre = null, cur = node, next = cur.next;
        while (next != null) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = cur.next;
        }
        cur.next = pre;

        return cur;
    }

    private static class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        /**
         * @return the next
         */
        public Node getNext() {
            return next;
        }

        /**
         * @param next : the next to set
         */
        public void setNext(Node next) {
            this.next = next;
        }

    }
}
