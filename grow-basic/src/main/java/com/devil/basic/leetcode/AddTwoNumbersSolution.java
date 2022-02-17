package com.devil.basic.leetcode;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * @author Devil
 * @date Created in 2021/6/25 16:38
 */
public class AddTwoNumbersSolution {

    /**
     * 递归用的进位
     */
    private static int forward1 = 0;

    public static ListNode solutionOne(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null && forward1 == 0) {
            return null;
        }
        int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + forward1;
        forward1 = sum / 10;
        return new ListNode(sum % 10, solutionOne(l1 == null ? null : l1.next, l2 == null ? null : l2.next));
    }

    public static ListNode solutionTwo(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int forward2 = 0;
        while (l1 != null || l2 != null) {
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + forward2;
            forward2 = sum / 10;

            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (forward2 > 0) {
            tail.next = new ListNode(forward2);
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(7);
        ListNode node2 = new ListNode(6, node1);
        ListNode node3 = new ListNode(8, node2);

        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(6, node4);
        ListNode node6 = new ListNode(5, node5);

        System.out.println(node3);
        System.out.println(node6);
        ListNode root = solutionTwo(node3, node6);
        System.out.println(root);
        ListNode root2 = solutionOne(node3, node6);
        System.out.println(root2);
    }

}
