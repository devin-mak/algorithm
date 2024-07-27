package com.wheat.algorithm.base.linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author maij
 * @description:
 * @date 2024-07-17 09:59
 **/
public class SortList {

    public ListNode sortList(ListNode head) {
        List<Integer> values = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            values.add(node.val);
            node = node.next;
        }
        Collections.sort(values);
        ListNode newNode = head;
        int i = 0;
        while (newNode != null) {
            newNode.val = values.get(i++);
            newNode = newNode.next;
        }
        return head;
    }
}
