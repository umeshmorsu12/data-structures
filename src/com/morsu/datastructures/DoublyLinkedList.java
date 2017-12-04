package com.morsu.datastructures;

/*
    append -> O(n)
    prepend -> O(1)
    delete -> O(n)
    insertAfterElement -> O(n)
    insertBeforeElement -> O(n)
    insertAfter -> O(1)
    insertBefore -> O(1)

 */

public class DoublyLinkedList {

    private static class Node {
        Node next;
        Node prev;
        int data;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

    private Node head;
    private int size = 0;

    public void append(int data) {
        Node node = new Node(data);

        if (head == null) {
            head = node;
            size++;
            return;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = node;
        node.prev = current;
        size++;
    }

    public void prepend(int data) {
        Node node = new Node(data);

        if (head == null){
            head = node;
            size++;
            return;
        }

        node.next = head;
        head.prev = node;
        head = node;
        size++;
    }

    public boolean deleteWithValue(int data) {
        if (head == null)
            return false;

        Node current = head;

        if (head.data == data) {
            head = head.next;
            size--;
            return true;
        }

        while (current.next != null) {
            if ( current.next.data == data) {
                current.next = current.next.next;
                current.next.prev = current;
                size--;
                return true;
            }

            current = current.next;
        }

        return false;
    }

    public void insertAfterElement(int after, int data) {
        Node node = new Node(data);
        if (head == null) {
           throw new RuntimeException("No elements found in the LinkedList");
        }

        if (head.data == after) {
            node.next = head.next;
            head.next = node;
            node.prev = head;
            size++;
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.data == after) {
               node.next = current.next;
               node.prev = current;
               current.next.prev = node;
               current.next = node;
                size++;
               return;
            }

            if ( current.next.next == null && current.next.data == after) {
                current.next.next = node;
                node.prev = current.next;
                size++;
                return;
            }

            current = current.next;
        }
    }


    public void insertBeforeElement(int before, int data) {

        if (head == null) throw new RuntimeException("No elements present int he list");

        Node node = new Node(data);

        if (head.data == before) {
            node.next = head;
            head.prev = node;
            head = node;
            size++;
            return;
        }

        Node current = head;

        while (current.next != null) {
            if ( current.data == before) {

                current.prev.next = node;
                node.prev = current.prev;
                current.prev = node;
                node.next = current;
                size++;
                return;
            }

            if ( current.next.data == before && current.next.next == null) {


                node.next = current.next;
                current.next.prev = node;
                current.next = node;
                node.prev = current;
                size++;
                return;
            }

            current = current.next;
        }
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printLinkedList() {
        Node current = this.head;
        System.out.print("LinkedList contents: ");
        while (current != null) {
            System.out.print(current.data + ((current.next != null)? " -> ": "" ));
            current = current.next;
        }
        System.out.println("");
    }

    public int peek() {
        if (head == null) throw new RuntimeException("No elements found in the LinkedList");

        return head.data;
    }

    public static void main(String args[]) {
        DoublyLinkedList linkedList = new DoublyLinkedList();
        System.out.println(" Is Empty: " + linkedList.isEmpty());
        System.out.println("Size: " + linkedList.size());
        linkedList.append(1);
        System.out.println("Size: " + linkedList.size());
        linkedList.printLinkedList();
        linkedList.deleteWithValue(1);
        linkedList.prepend(1);
        linkedList.prepend(2);
        linkedList.prepend(3);
        linkedList.append(4);
        linkedList.append(5);
        linkedList.prepend(6);
        linkedList.printLinkedList();
        System.out.println("Size: " + linkedList.size());
        linkedList.deleteWithValue(2);
        linkedList.printLinkedList();
        linkedList.printLinkedList();
        linkedList.insertAfterElement(1, 8);
        linkedList.printLinkedList();
        linkedList.insertAfterElement(8, 9);
        linkedList.printLinkedList();
        linkedList.insertBeforeElement(1, 10);
        linkedList.printLinkedList();
        linkedList.insertAfterElement(5, 11);
        linkedList.printLinkedList();
        linkedList.insertBeforeElement(11, 12);
        linkedList.printLinkedList();
        linkedList.insertAfterElement(12, 13);
        linkedList.printLinkedList();
        System.out.println(" Is Empty: " + linkedList.isEmpty());

        System.out.println("PEEK: " + linkedList.peek());
        System.out.println("Size: " + linkedList.size());
    }

}
