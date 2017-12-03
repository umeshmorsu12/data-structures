package com.morsu.datastructures;

/*
    LIFO data structure

    Average Time Complexity
    -----------------------
    Access/Search - O(n)
    Insertion - O(1)
    Deletion - O(1)

    Worst Time Complexity
    ---------------------
    Access/Search - O(n)
    Insertion - O(1)
    Deletion - O(1)
 */

public class Stack {

    private static class Node {
        private int data;
        private Node next;

        private Node(int data) {
            this.data = data;
        }
    }

    private Node top;
    private int size = 0;

    public boolean isEmpty() {
        return this.top == null;
    }

    public void push(int data) {
        Node node = new Node(data);
        node.next = top;
        top = node;
        this.size++;
    }

    public int pop() {
        if (top == null) throw new RuntimeException("No elements present the Stack");
        this.size--;
        int data = top.data;
        top = top.next;
        return data;
    }

    public int peek() {
        if (top == null) throw new RuntimeException("No elements present the Stack");
        return top.data;
    }

    public int size() {
        return this.size;
    }

    public boolean find(int data){
        if (top == null) return false;

        Node current = top;

        while(current.next != null) {
            if (current.data == data) {
                return true;
            }

            current = current.next;
        }

        return false;
    }

    private void printStack() {
        Node current = this.top;
        System.out.print("Stack contents: ");
        while (current != null) {
            System.out.print(current.data + ((current.next != null)? " -> ": "" ));
            current = current.next;
        }
        System.out.println("");
    }

    public static void main(String args[]) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.printStack();
        stack.pop();
        stack.printStack();
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println("Size of stack# " + stack.size());
        stack.pop();
        stack.printStack();
        stack.push(6);
        stack.push(7);
        System.out.println("Finding 7# " + stack.find(7));
        System.out.println("Size of stack# " + stack.size());
        stack.printStack();
    }
}
