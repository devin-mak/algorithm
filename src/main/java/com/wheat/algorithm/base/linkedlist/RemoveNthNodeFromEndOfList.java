package com.wheat.algorithm.base.linkedlist;

/**
 * @author maij
 * @description:
 * @date 2024-06-04 18:10
 **/
public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        ListNode n5 = new ListNode(5);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, null);
        ListNode n1 = new ListNode(1, n2);

        RemoveNthNodeFromEndOfList removeNthNodeFromEndOfList = new RemoveNthNodeFromEndOfList();
        removeNthNodeFromEndOfList.removeNthFromEnd(n1, 2);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode a = head;
        int i = n;
        while (i > 0) {
            a = a.next;
            i--;
        }
        if (a == null) {
            return head.next;
        }
        ListNode b = head;
        while (a.next != null) {
            a = a.next;
            b = b.next;
        }
        b.next = b.next.next;
        return head;
    }

    private static class ListNode {
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
    }
}
