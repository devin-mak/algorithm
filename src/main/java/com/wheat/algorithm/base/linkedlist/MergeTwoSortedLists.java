package com.wheat.algorithm.base.linkedlist;

/**
 * @author maij
 * @description:
 * @date 2024-06-04 16:13
 **/
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode l13 = new ListNode(4);
        ListNode l12 = new ListNode(2, l13);
        ListNode l11 = new ListNode(1, l12);

        ListNode l23 = new ListNode(4);
        ListNode l22 = new ListNode(3, l23);
        ListNode l21 = new ListNode(1, l22);

        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        ListNode listNode = mergeTwoSortedLists.mergeTwoLists(l11, l21);
        System.out.println(listNode);
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }
        ListNode head = new ListNode();
        ListNode node = head;
        ListNode n1 = list1, n2 = list2;
        while (n1 != null && n2 != null) {
            if (n1.val <= n2.val) {
                node.next = n1;
                node = n1;
                n1 = n1.next;
            } else {
                node.next = n2;
                node = n2;
                n2 = n2.next;
            }
        }
        if (n1 == null) {
            node.next = n2;
        } else {
            node.next = n1;
        }
        return head.next;
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
