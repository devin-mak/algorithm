package com.wheat.algorithm.base.linkedlist;

/**
 * @author maij
 * @description:
 * @date 2024-06-05 11:13
 **/
public class ReverseNodesInKGroup {

    public static void main(String[] args) {
        ListNode n7 = new ListNode(7);
        ListNode n6 = new ListNode(6, n7);
        ListNode n5 = new ListNode(5, n6);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);

        ReverseNodesInKGroup reverseNodesInKGroup = new ReverseNodesInKGroup();
        ListNode node = reverseNodesInKGroup.reverseKGroup(n1, 2);
        System.out.println(node);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode node = reverse(head, k);
        if (node == null) {
            return head;
        }
        ListNode newHead = node;
        ListNode tail = head;
        while (tail.next != null) {
            ListNode temp = tail.next;
            node = reverse(tail.next, k);
            if (node == null) {
                break;
            }
            tail.next = node;
            tail = temp;
        }
        return newHead;
    }

    public ListNode reverse(ListNode head, int k) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode a = head;
        int nk = k;
        while (nk > 0) {
            if (a == null) {
                return a;
            }
            nk--;
            a = a.next;
        }
        ListNode prev = null, current = head;
        while (current != null && k > 0) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
            k--;
        }
        head.next = current;
        return prev;
    }
}
