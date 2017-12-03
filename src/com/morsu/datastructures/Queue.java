package com.morsu.datastructures;

/*
    FIFO data structure

    Average/Worst Case (Time)
    -------------------
    Access/Search -> O(n)
    Insertion/Deletion - O(1)

 */

public class Queue {
    private static class Node {
        private int data;
        private Node next;
        private Node(int data) {
            this.data = data;
        }
    }

    Node head, tail;

    public boolean isEmpty() {
        return head == null;
    }

    public int peek() {
        if (head == null) throw new RuntimeException("No elements in Q");

        return head.data;
    }

    public void add(int data) {
        Node node = new Node(data);

        if (tail != null) {
            tail.next = node;
            tail = tail.next;
        }

        tail = node;

        if (head == null)
            head = node;
    }

    public int remove() {
        if (head == null) throw new RuntimeException("No elements in Q");

        int data = head.data;

        head = head.next;

        if (head == null)
            tail = null;

        return data;
    }

    public static void main(String args[]) {

    }
}
