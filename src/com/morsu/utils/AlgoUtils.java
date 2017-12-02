package com.morsu.utils;

import java.util.Scanner;

/*
    Simple methods for algorithm usage
 */
public abstract class AlgoUtils {

    public static void printArray(int[] array) {

        System.out.print(" [ ");

        for (int index=0; index < array.length; index++) {
            System.out.print(array[index] + " ");
        }
        System.out.println(" ] ");
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
}
