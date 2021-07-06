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
//        System.out.println(isCircleOne(node0));
        System.out.println(isCircleTwo(node0));
    }

    public static boolean isCircleOne(Node node) {
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

    public static boolean isCircleTwo(Node node) {
        Node slow = node;
        Node fast = node.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == null) {
                return false;
            } else if (slow == fast) {
                return true;
            }
        }

        return false;
    }

}
