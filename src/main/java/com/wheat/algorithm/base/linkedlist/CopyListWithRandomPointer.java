package com.wheat.algorithm.base.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * @author maij
 * @description:
 * @date 2024-07-17 00:31
 **/
public class CopyListWithRandomPointer {

    public static void main(String[] args) {
//        Node n1 = new Node(1);
//
//        Node n2 = new Node(10);
//        n2.next = n1;
//
//        Node n3 = new Node(11);
//        n3.next = n2;
//
//        Node n4 = new Node(13);
//        n4.next = n3;
//
//        Node n5 = new Node(7);
//        n5.next = n4;
//
//        n1.random = n5;
//        n2.random = n3;
//        n3.random = n1;
//        n4.random = n5;

        Node n1 = new Node(2);

        Node n2 = new Node(1);
        n2.next = n1;

        n1.random = n1;
        n2.random = n1;

        Node node = copyRandomList(n2);
        System.out.println(node);
    }

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node newHead = new Node(head.val);
        Map<Integer, Node> nodeMap = new HashMap<>();
        nodeMap.put(head.hashCode(), newHead);
        if (head.random != null) {
            newHead.random = nodeMap.computeIfAbsent(head.random.hashCode(), (t) -> new Node(head.random.val));
        }
        Node node = head.next;
        Node current = newHead;
        while (node != null) {
            final Node n = node;
            Node newNode = nodeMap.computeIfAbsent(node.hashCode(), (t) -> new Node(n.val));
            current.next = newNode;
            if (node.random != null) {
                newNode.random = nodeMap.computeIfAbsent(node.random.hashCode(), (t) -> new Node(n.random.val));
            }
            current = newNode;
            node = node.next;
        }
        return newHead;
    }


    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
