package com.morsu.sorting;


import com.morsu.utils.AlgoUtils;

/*

        Worst-case performance: 	 O(n^2)
        Best-case performance:  	 O(n log n) (simple partition) or O(n) (three-way partition and equal keys)
        Average performance:	     O(n log n)
        Worst-case space complexity: O(n) auxiliary (naive) O(log n) auxiliary
 */
public class QuickSort {

    public static void sort(int[] inputArray, int left, int right){
        int index = partition(inputArray, left, right);

        if (left < index-1)
            sort(inputArray,left, index - 1);

        if (index < right)
            sort(inputArray,index, right);

    }

    private static int partition(int[] inputArray, int left, int right) {


        int i = left, j = right;
        int tmp;
        int pivot = inputArray[(left + right) / 2];

        System.out.println("------------ START PASS ---------------");
        System.out.println(" Pivot# " + pivot +
                            " left# " + left +
                            " right# " + right);
        while ( i <= j ) {
            while (inputArray[i] < pivot)
                i++;

            while (inputArray[j] > pivot)
                j--;

            if ( i <= j ) {
                tmp = inputArray[i];
                inputArray[i] = inputArray[j];
                inputArray[j] = tmp;
                i++;
                j--;
            }
        }
        System.out.print("Array at end of pass: ");
        AlgoUtils.printArray(inputArray);
        System.out.println("------------ END PASS ---------------");

        return i;
    }


    public static void main(String args[]) {
        int[] inputArray = AlgoUtils.getInputArray();

        int left = 0, right = inputArray.length-1;
        AlgoUtils.printArray(inputArray);
        sort(inputArray, left, right);
        AlgoUtils.printArray(inputArray);
    }
}
