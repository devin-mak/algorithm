package com.wheat.algorithm.base.linkedlist;

/**
 * @author maij
 * @description:
 * @date 2024-06-04 15:06
 **/
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        ListNode a = head, b = head;
        while (b != null && b.next != null) {
            a = a.next;
            b = b.next.next;
            if (a == b) {
                return true;
            }
        }
        return false;
    }
}
