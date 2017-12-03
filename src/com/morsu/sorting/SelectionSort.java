package com.morsu.sorting;

import com.morsu.utils.AlgoUtils;

/*
    selection sort is a sorting algorithm, specifically an in-place comparison sort.
    It has O(n2) time complexity, making it inefficient on large lists, and generally
    performs worse than the similar insertion sort. Selection sort is noted for its
    simplicity, and it has performance advantages over more complicated algorithms in
    certain situations, particularly where auxiliary memory is limited.

    Worst-case performance	    О(n2) comparisons, О(n) swaps
    Best-case performance	    О(n2) comparisons, О(n) swaps
    Average performance 	    О(n2) comparisons, О(n) swaps
    Worst-case space complexity	О(n) total, O(1) auxiliary
 */

public class SelectionSort extends Sort {

    public void sort(int[] inputArray) {

        int minValue, minIndex, temp = 0;
        for (int i = 0; i < inputArray.length; i++) {
            System.out.println("------------- BEGIN PASS# " + i + "-----------");
            minValue = inputArray[i];
            minIndex = i;

            System.out.println("Min Value# " + minValue + " minIndex# " + minIndex);

            for (int j = i; j < inputArray.length; j++) {
                if (inputArray[j] < minValue) {
                    minValue = inputArray[j];
                    minIndex = j;
                }
            }

            if (minValue < inputArray[i]) {
                temp = inputArray[i];
                inputArray[i] = inputArray[minIndex];
                inputArray[minIndex] = temp;
            }

            AlgoUtils.printArray(inputArray);
            System.out.println("------------- END PASS# " + i + "-----------");
        }
    }

    public static void main(String args[]) {
       run(new SelectionSort());
    }
}
