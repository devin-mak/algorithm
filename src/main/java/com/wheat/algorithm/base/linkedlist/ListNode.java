package com.wheat.algorithm.base.linkedlist;

/**
 * @author maij
 * @description:
 * @date 2024-07-15 11:53
 **/
public class ListNode {

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
