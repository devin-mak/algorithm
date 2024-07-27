package com.wheat.algorithm.base.linkedlist;

/**
 * @author maij
 * @description:
 * @date 2024-06-04 17:36
 **/
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l13 = new ListNode(3);
        ListNode l12 = new ListNode(4, l13);
        ListNode l11 = new ListNode(2, l12);

        ListNode l23 = new ListNode(4);
        ListNode l22 = new ListNode(6, l23);
        ListNode l21 = new ListNode(5, l22);

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode listNode = addTwoNumbers.addTwoNumbers(l11, l21);
        System.out.println(listNode);
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode();
        ListNode node = head;
        ListNode n1 = l1, n2 = l2;
        boolean carry = false;
        while (n1 != null || n2 != null) {
            int i = n1 == null ? 0 : n1.val;
            int j = n2 == null ? 0 : n2.val;
            int sum = (carry ? 1 : 0) + i + j;
            if (sum >= 10) {
                carry = true;
                sum -= 10;
            } else {
                carry = false;
            }
            node.next = new ListNode(sum);
            node = node.next;
            if (n1 != null) {
                n1 = n1.next;
            }
            if (n2 != null) {
                n2 = n2.next;
            }
        }
        if (carry) {
            node.next = new ListNode(1);
        }
        return head.next;
    }
}
