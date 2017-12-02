package com.morsu.sorting;


/*
    Merge sort is very efficient for larger data-sets

    Worst-case performance:	O(n log n)
    Best-case performance:  O(n log n) typical, O(n) natural variant
    Average performance:	O(n log n)
    Worst-case space complexity:	О(n) total, O(n) auxiliary
 */

import com.morsu.utils.AlgoUtils;

public class MergeSort {

    public static void sort(int[] inputArray) {
        mergeSort(inputArray, 0, inputArray.length - 1);
    }

    public static void mergeSort(int[] list, int lowIndex, int highIndex) {
        if (lowIndex == highIndex) {
            return;
        } else {
            int midIndex = (lowIndex + highIndex) /2;
            mergeSort(list, lowIndex, midIndex);
            mergeSort(list, midIndex+1, highIndex);
            merge(list, lowIndex, midIndex, highIndex);
        }
    }

    public static void merge(int[] list, int lowIndex, int midIndex, int highIndex) {

            System.out.println(" ----------- START PASS -------------");
            // Initialize Left split array
            int[] left = new int[midIndex - lowIndex + 2];

            for ( int i = lowIndex; i <= midIndex; i++) {
                left[i-lowIndex] = list[i];
            }

            // Set super max, to have sizable comparison at the end
            left[midIndex-lowIndex + 1] = Integer.MAX_VALUE;

            System.out.print(" Left: ");
            AlgoUtils.printArray(left);

            // Initialize right split array
            int[] right = new int[highIndex - midIndex + 1];

            for (int i = midIndex + 1; i <= highIndex; i++) {
                right[i-midIndex-1] = list[i];
            }

            // Set super max to have sizable comparison at the end
            right[highIndex - midIndex] = Integer.MAX_VALUE;

            System.out.print(" Right: ");
            AlgoUtils.printArray(right);

            int i = 0, j = 0;

            for (int k = lowIndex; k <= highIndex; k++) {
                if (left[i] <= right[j]) {
                    list[k] = left[i];
                    i++;
                } else {
                    list[k] = right[j];
                    j++;
                }
            }
        System.out.print(" List: ");
        AlgoUtils.printArray(list);
        System.out.println(" ----------- END PASS -------------");
    }


    public static void main(String args[]) {
        int[] inputArray = AlgoUtils.getInputArray();
        System.out.print("Input Array: ");
        AlgoUtils.printArray(inputArray);
        sort(inputArray);
        System.out.print("Sorted Array: ");
        AlgoUtils.printArray(inputArray);
    }

}
