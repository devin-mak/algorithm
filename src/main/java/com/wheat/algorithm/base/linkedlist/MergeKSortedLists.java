package com.wheat.algorithm.base.linkedlist;

/**
 * @author maij
 * @description:
 * @date 2024-07-17 11:08
 **/
public class MergeKSortedLists {

    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[3];
        ListNode l11 = new ListNode(5);
        ListNode l12 = new ListNode(4, l11);
        ListNode l13 = new ListNode(1, l12);
        listNodes[0] = l13;

        ListNode l21 = new ListNode(4);
        ListNode l22 = new ListNode(3, l21);
        ListNode l23 = new ListNode(1, l22);
        listNodes[1] = l23;

        ListNode l31 = new ListNode(6);
        ListNode l32 = new ListNode(2, l31);
        listNodes[2] = l32;

        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
        ListNode node = mergeKSortedLists.mergeKLists(listNodes);
        System.out.println(node);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode head = new ListNode(Integer.MIN_VALUE);
        ListNode prev = null;
        for (ListNode list : lists) {
            ListNode n1 = list;
            ListNode n2 = head;
            while (n1 != null && n2 != null) {
                if (n1.val > n2.val) {
                    prev = n2;
                    n2 = n2.next;
                    continue;
                }
                ListNode node = new ListNode(n1.val);
                if (prev != null) {
                    prev.next = node;
                }
                node.next = n2;
                prev = node;
                n1 = n1.next;
            }
            while (n1 != null) {
                prev.next = new ListNode(n1.val);
                prev = prev.next;
                n1 = n1.next;
            }
        }
        return head.next;
    }
}
