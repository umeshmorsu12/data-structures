package com.morsu.utils;

import java.util.Arrays;
import java.util.Scanner;

/*
    Simple methods for algorithm usage
 */
public abstract class AlgoUtils {

    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static int[] getInputArray() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter size of array: ");
        int length = scan.nextInt();
        int[] inputArray = new int[length];

        System.out.println("Enter elements in array: ");
        for (int index = 0; index < length; index++) {
            inputArray[index] = scan.nextInt();
        }
        return inputArray;
    }

    public static void swap(int[] inputArray, int fromIndex, int toIndex) {
        int temp = inputArray[fromIndex];
        inputArray[fromIndex] = inputArray[toIndex];
        inputArray[toIndex] = temp;
    }
}
