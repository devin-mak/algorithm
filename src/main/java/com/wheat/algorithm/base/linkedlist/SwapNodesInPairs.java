package com.wheat.algorithm.base.linkedlist;

/**
 * @author maij
 * @description:
 * @date 2024-06-05 10:18
 **/
public class SwapNodesInPairs {

    public static void main(String[] args) {
        ListNode n5 = new ListNode(5);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();
        ListNode listNode = swapNodesInPairs.swapPairs(n1);
        System.out.println(listNode.val);
    }
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode h = head.next;
        ListNode node = head, prev = null;
        while (node != null && node.next != null) {
            if (prev != null) {
                prev.next = node.next;
            }
            ListNode tempNode = node.next.next;
            node.next.next = node;
            node.next = tempNode;
            prev = node;
            node = tempNode;
        }
        return h;
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
    }

}
