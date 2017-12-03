package com.morsu.datastructures;

import java.util.Arrays;

/*
    Linear Data structure
    Flexible Size
    Stack uses LIFO (Last In First Out)

    Pop -> O(1)
    Push -> O(1)
 */
public class StackArrayBased {

    private Object[] table;
    private int size = 0;
    private int capacity = 0;

    // O(1)
    public StackArrayBased(int capacity) {
        this.capacity = capacity;
        this.table = new Object[capacity];
    }

    // O(1)
    public Object pop() {
        if ( size == 0)
            throw new RuntimeException("No Elements in the stack");

        Object poppedElement = this.table[size-1];
        this.table[size-1] = null;
        size--;
        return poppedElement;
    }

    // O(1)
    public void push(Object entry) {
        if ((size + 1) > capacity)
            throw new RuntimeException("Stack overflow error!");

        this.table[size++] = entry;
    }

    public int size() {
        return size;
    }

    public void printStack() {
        System.out.println(Arrays.toString(this.table));
    }

    public static void main(String args[]) {
        StackArrayBased stack = new StackArrayBased(5);
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");
        stack.printStack();
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println("Size of stack# " + stack.size());
        stack.printStack();
        stack.push("6");
        stack.push("7");
        System.out.println("Size of stack# " + stack.size());
        stack.printStack();
    }
}
