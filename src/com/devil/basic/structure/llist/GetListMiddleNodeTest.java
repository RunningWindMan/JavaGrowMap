package com.devil.basic.structure.llist;

/**
 * 求链表中间节点 (快慢指针  一个走一步  一个走两步)
 *
 * @author Devil
 * @date Created in 2021/7/6 16:08
 */
public class GetListMiddleNodeTest {

    public static void main(String[] args) {
        Node node4 = new Node(4, null);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);

        Node middle = getMiddleNode(node1);
        System.out.println(middle.data);
    }

    public static Node getMiddleNode(Node node) {
        if (node == null || node.next == null || node.next.next == null) {
            return null;
        }

        Node slow = node;
        Node fast = node.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return fast == null ? slow : slow.next;
    }

}
