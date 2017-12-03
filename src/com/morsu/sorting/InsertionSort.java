package com.morsu.sorting;

import com.morsu.utils.AlgoUtils;

/*
    Insertion sort is a simple sorting algorithm that builds the final sorted array (or list) one item at a time. It is much less efficient on large lists than more advanced algorithms such as quicksort, heapsort, or merge sort. However, insertion sort provides several advantages:

        * Simple implementation
        * Efficient for (quite) small data sets, much like other quadratic sorting algorithms
        * More efficient in practice than most other simple quadratic (i.e., O(n2)) algorithms such as selection sort
            or bubble sort
        * Adaptive, i.e., efficient for data sets that are already substantially sorted: the time complexity is O(nk)
            when each element in the input is no more than k places away from its sorted position
        * Stable; i.e., does not change the relative order of elements with equal keys
        * In-place; i.e., only requires a constant amount O(1) of additional memory space
        * Online; i.e., can sort a list as it receives it

        Worst-case performance	О(n2) comparisons, swaps
        Best-case performance	O(n) comparisons, O(1) swaps
        Average performance	О(n2) comparisons, swaps
        Worst-case space complexity	О(n) total, O(1) auxiliary
 */
public class InsertionSort extends Sort {

    public void sort(int[] inputArray) {

        for (int i = 1; i < inputArray.length; i++) {
            System.out.println("------------- BEGIN PASS# " + i + "-----------");

            int key = inputArray[i];

            int j = i-1;

            while(j >= 0 && key < inputArray[j]) {
                int temp = inputArray[j];
                inputArray[j] = inputArray[j+1];
                inputArray[j+1] = temp;
                j--;
            }
            System.out.print("Array after this pass: ");
            AlgoUtils.printArray(inputArray);
            System.out.println("------------- END PASS# " + i + "-----------");
        }
    }

    public static void main(String args[]) {
        run(new InsertionSort());
    }
}
