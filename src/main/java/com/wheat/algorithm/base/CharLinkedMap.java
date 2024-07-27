package com.wheat.algorithm.base;

/**
 * @author maij
 * @description:
 * @date 2024-05-14 16:49
 **/
public class CharLinkedMap {

    public static void main(String[] args) {
        CharLinkedMap map = new CharLinkedMap();
        map.put('a', 0);
        map.put('c', 1);
        map.put('c', 2);
        map.put('b', 3);
        map.put('b', 4);
        map.put('a', 5);
        map.removeFirst('a');
        map.put('b', 8);
        map.removeFirst('b');
        map.put('d', 11);
        map.put('c', 12);
        map.put('c', 13);
        map.removeFirst('c');
        map.removeFirst('c');
        Node n = map.head;
        while (n != null) {
            System.out.println(n.value);
            n = n.after;
        }
        System.out.println(map.pollFirst());
        n = map.head;
        while (n != null) {
            System.out.println(n.value);
            n = n.after;
        }
    }

    private final Entry[] entries = new Entry[128];
    private Node head, tail;

    private static class Entry {
        private Node head, tail;

    }

    private static class Node {

        char key;

        int value;

        Node next;

        Node before, after;

        Node(char key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(char key, int value) {
        Entry entry = entries[key];
        if (entry == null) {
            entry = new Entry();
            entries[key] = entry;
        }

        Node node = new Node(key, value);
        if (entry.head == null) {
            entry.head = node;
        }

        if (entry.tail != null) {
            entry.tail.next = node;
        }
        entry.tail = node;

        if (head == null) {
            head = node;
        }

        if (tail != null) {
            node.before = tail;
            tail.after = node;
        }
        tail = node;
    }

    public void removeFirst(char key) {
        Entry entry = entries[key];
        if (entry == null) {
            return;
        }
        if (entry.head == head) {
            head = head.after;
        } else {
            entry.head.before.after = entry.head.after;
            entry.head.after.before = entry.head.before;
        }
        entry.head = entry.head.next;
    }

    public int pollFirst() {
        if (head == null) {
            return -1;
        }
        Node h = head;
        head = head.after;
        Entry entry = entries[h.key];
        entry.head = entry.head.next;
        return h.value;
    }
}
