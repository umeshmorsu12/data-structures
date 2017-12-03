package com.morsu.sorting;


import com.morsu.utils.AlgoUtils;

import java.util.Random;

/*

        Worst-case performance: 	 O(n^2)
        Best-case performance:  	 O(n log n) (simple partition) or O(n) (three-way partition and equal keys)
        Average performance:	     O(n log n)
        Worst-case space complexity: O(n) auxiliary (naive) O(log n) auxiliary
 */
public class QuickSort extends Sort {


    public void sort(int[] inputArray) {
        quickSort(inputArray, 0, inputArray.length-1);
    }

    private  void quickSort(int[] inputArray, int low, int high) {
        if (low < high + 1) {
            int p = partition(inputArray, low, high);
            quickSort(inputArray, low, p-1);
            quickSort(inputArray, p + 1, high);

        }
    }

    private  int getPivot(int low, int high) {
        Random random = new Random();
        return random.nextInt((high-low) + 1) + low; // Inclusive
    }

    private  int partition(int[] inputArray, int low, int high) {
        AlgoUtils.swap(inputArray, low, getPivot(low, high));
        int border = low + 1;
        for (int i = border; i <= high; i++) {
            if (inputArray[i] < inputArray[low]) {
                AlgoUtils.swap(inputArray, i, border++);
            }
        }
        AlgoUtils.swap(inputArray,low, border-1);
        return border-1;
    }

    public static void main(String args[]) {
        run(new QuickSort());
    }
}
