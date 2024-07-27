package com.wheat.algorithm.base.linkedlist;

import java.io.OutputStream;
import java.util.*;

/**
 * @author maij
 * @description:
 * @date 2024-06-03 16:55
 **/
public class PalindromeLinkedList {

    public static void main(String[] args) {
        ListNode n5 = new ListNode(1);
        ListNode n4 = new ListNode(2, n5);
        ListNode n3 = new ListNode(2, n4);
        ListNode n2 = new ListNode(1, n3);

        PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
        System.out.println(palindromeLinkedList.isPalindrome(n4));
    }

    public boolean isPalindrome(ListNode head) {
        ListNode a = head, b = head;
        while (b != null && b.next != null) {
            a = a.next;
            b = b.next.next;
        }
        Deque<ListNode> listNodes = new LinkedList<>();
        while (a != null) {
            listNodes.add(a);
            a = a.next;
        }
        ListNode c = head;
        while (listNodes.peekLast() != null && c != null) {
            ListNode listNode = listNodes.pollLast();
            if (listNode.val != c.val) {
                return false;
            }
            c = c.next;
        }
        return true;
    }

    public boolean isPalindrome2(ListNode head) {
        Deque<ListNode> listNodes = new LinkedList<>();
        ListNode a = head;
        while (a != null) {
            listNodes.add(a);
            a = a.next;
        }

        while (listNodes.size() > 1) {
            ListNode n1 = listNodes.pollLast();
            ListNode n2 = listNodes.pollFirst();
            if (n2.val != n1.val) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome3(ListNode head) {
        List<Integer> values = new ArrayList<>();
        ListNode a = head;
        while (a != null) {
            values.add(a.val);
            a = a.next;
        }
        int i = 0, j = values.size();
        while (i < j) {
            if (!values.get(i).equals(values.get(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

//    public boolean isPalindrome(ListNode head) {
//        int l = 0;
//        ListNode a = head, b = head;
//        while (b != null) {
//            a = a.next;
//            b = b.next == null ? null : b.next.next;
//        }
//
//    }

    public static ReverseLinkedList.ListNode reverseList2(ReverseLinkedList.ListNode head) {
        ReverseLinkedList.ListNode prev = null, current = head;
        while (current != null) {
            ReverseLinkedList.ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
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
