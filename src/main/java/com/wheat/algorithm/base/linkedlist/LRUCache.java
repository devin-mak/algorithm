package com.wheat.algorithm.base.linkedlist;

import com.wheat.algorithm.base.CharLinkedMap;

import java.util.Optional;

/**
 * @author maij
 * @description:
 * @date 2024-07-18 11:19
 **/
public class LRUCache {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }

    private Node head, tail;

    private final Entry[] entries;

    private int size;

    public LRUCache(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("capacity illegal");
        }
        entries = new Entry[capacity];
    }

    public int get(int key) {
        int index = getIndex(key);
        Entry entry = entries[index];
        Node node = getNode(key, entry);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        int index = getIndex(key);
        Entry entry = entries[index];
        if (entry == null) {
            entry = new Entry();
            entries[index] = entry;
        }
        Node node = getNode(key, entry);
        if (node == null) {
            putEntry(key, value, entry);
            if (size == entries.length) {
                if (tail.prev == null && tail.next == null) {
                    entries[index] = null;
                } else {
                    if (tail == entry.head) {
                        entry.head = entry.head.next;
                        entry.head.prev = null;
                    } else {
                        Node prev = tail.prev;
                        if (tail.prev != null) {
                            tail.prev = tail.next;
                        }
                        if (tail.next != null) {
                            tail.next.prev = prev;
                        }
                    }
                }
                tail.before.after = null;
                tail = tail.before;
            } else {
                size++;
            }
        } else {
            node.val = value;
            moveToHead(node);
        }
    }

    private void moveToHead(Node node) {
        if (node == head) {
            return;
        }
        if (node == tail) {
            tail = tail.before;
        }
        node.before.after = node.after;
        if (head != null) {
            node.after = head;
            head.before = node;
        }
        node.before = null;
        head = node;
    }

    private int getIndex(int key) {
        return key % entries.length;
    }

    private void putEntry(int key, int value, Entry entry) {

        Node node = new Node();
        node.key = key;
        node.val = value;
        if (entry.head == null) {
            entry.head = node;
        }
        if (entry.tail == null) {
            entry.tail = node;
        } else {
            node.prev = entry.tail;
            entry.tail.next = node;
            entry.tail = node;
        }

        if (head == null) {
            head = node;
        } else {
            node.after = head;
            head.before = node;
            head = node;
        }

        if (tail == null) {
            tail = node;
        }
    }

    private static Node getNode(int key, Entry entry) {
        Node node = entry.head;
        while (node != null) {
            if (node.key == key) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    class Entry {
        Node head, tail;
    }

    class Node {

        int key;

        int val;

        Node prev, next;

        Node before, after;
    }
}
