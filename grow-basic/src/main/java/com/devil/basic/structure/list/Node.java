package com.devil.basic.structure.list;

/**
 * 单链表节点
 *
 * @author Devil
 * @date Created in 2021/7/6 15:35
 */
public class Node {
    
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
     * @param next : the next to set
     */
    public void setNext(Node next) {
        this.next = next;
    }
    
    public void printNode(Node node) {
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
    
}
