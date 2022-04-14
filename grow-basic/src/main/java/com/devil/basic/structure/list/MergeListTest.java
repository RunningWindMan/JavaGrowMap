package com.devil.basic.structure.list;

/**
 * 两个有序链表合并（默认正序）
 *
 * @author Devil
 * @date Created in 2021/7/6 13:31
 */
public class MergeListTest {
    
    public static void main(String[] args) {
        Node node4 = new Node(4, null);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);
        
        Node node9 = new Node(4, null);
        Node node8 = new Node(3, node9);
        Node node7 = new Node(2, node8);
        Node node6 = new Node(1, node7);
        
        Node result = merge(node1, node6);
        result.printNode(result);
        
    }
    
    public static Node merge(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return null;
        }
        
        if (node1 == null) {
            return node2;
        }
        
        if (node2 == null) {
            return node1;
        }
        
        Node cur1 = node1;
        Node cur2 = node2;
        
        Node head, cur;
        if (cur1.data <= cur2.data) {
            head = cur1;
            cur1 = cur1.next;
        } else {
            head = cur2;
            cur2 = cur2.next;
        }
        cur = head;
        
        while (cur1 != null && cur2 != null) {
            if (cur1.data <= cur2.data) {
                cur.next = cur1;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        
        while (cur1 != null) {
            cur.next = cur1;
            cur = cur.next;
            cur1 = cur1.next;
        }
        
        while (cur2 != null) {
            cur.next = cur2;
            cur = cur.next;
            cur2 = cur2.next;
        }
        
        return head;
    }
    
}
