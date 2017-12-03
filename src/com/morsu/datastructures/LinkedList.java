package com.morsu.datastructures;

/*
        Average/Worst case time
        -----------------------
        Access/Search -> O(n)
        Insert/Delete -> O(1) (first element), O(n) (nth element)
 */

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class LinkedList {
    private Node head;

    public void append(int data) {
        if (head == null) {
            head = new Node(data);;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(data);;
    }

    public void prepend(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        this.head = newNode;
    }

    public boolean deleteWithValue( int data) {
        Node current = this.head;

        if (head == null)
            return false;

        if (head.data == data) {
            head = head.next;
            return true;
        }

        while (current.next != null) {
            if ( current.next.data == data) {
                current.next = current.next.next;
                return  true;
            }

            current = current.next;
        }

        return false;
    }

    public boolean find(int data) {
        Node current = head;

        if (head == null) return false;

        if (head.data == data) return true;

        while(current.next != null) {
            if (current.data == data)
                return true;

            current = current.next;
        }

        return false;
    }

    public int readFirst() {
        if (head == null) throw new RuntimeException("No elements in the linked list");

        return head.data;
    }

    public int readLast() {
        if (head == null)
            throw new RuntimeException("No elements in the linked list");

        if (head.next == null)
            return head.data;

        Node current = head;

        while (current.next != null) {
            if (current.next.next == null) {
                return current.next.data;
            }
            current = current.next;
        }

        throw new RuntimeException("No elements in the linked list");
    }


    private void printLinkedList() {
        Node current = this.head;
        System.out.print("LinkedList contents: ");
        while (current != null) {
            System.out.print(current.data + ((current.next != null)? " -> ": "" ));
            current = current.next;
        }
        System.out.println("");
    }

    public static void main(String args[]) {
        LinkedList list = new LinkedList();
        System.out.println("Appending 1,2,3 ");
        list.append(1);
        list.append(2);
        list.append(3);
        list.printLinkedList();
        System.out.println("Prepending 4 ");
        list.prepend(4);
        list.printLinkedList();
        System.out.println("Deleting 3 ");
        list.deleteWithValue(3);
        list.printLinkedList();
        System.out.println("Finding 4: " + list.find(4));
        System.out.println("Finding 3: " + list.find(3));
        list.printLinkedList();
        System.out.println("First element: " + list.readFirst());
        System.out.println("Last element: " + list.readLast());
    }
}