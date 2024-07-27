package com.wheat.algorithm.base.linkedlist;

/**
 * @author maij
 * @description:
 * @date 2024-07-15 11:59
 **/
public class LinkedListCycleII {

    public static void main(String[] args) {

    }

    public ListNode detectCycle(ListNode head) {
        ListNode a = head, b = head;
        while (b != null && b.next != null) {
            a = a.next;
            b = b.next.next;
            if (a == b) {
                break;
            }
        }
        if (b == null || b.next == null) {
            return null;
        }
        ListNode c = head;
        while (c != null && a != null) {
            if (c == a) {
                return c;
            }
            c = c.next;
            a = a.next;
        }
        return null;
    }
}
