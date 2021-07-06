package com.devil.basic.structure.llist;

import java.util.HashMap;
import java.util.Map;

/**
 * 链表中环的检测
 *
 * @author Devil
 * @date Created in 2021/7/6 11:46
 */
public class ListCircleTest {

    public static void main(String[] args) {
        Node node4 = new Node(4, null);
        Node node3 = new Node(3, null);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node3);
        Node node0 = new Node(0, node1);
        node3.setNext(node1);
        System.out.println(isCircle(node0));
    }

    public static boolean isCircle(Node node) {
        boolean result = false;
        if (node != null) {
            Map<Node, Integer> dataMap = new HashMap<>();
            Node cur = node;
            while (cur != null) {
                if (dataMap.get(cur) != null) {
                    result = true;
                    break;
                }
                dataMap.put(cur, cur.data);
                cur = cur.next;
            }
        }
        return result;
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

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }
    }

}
