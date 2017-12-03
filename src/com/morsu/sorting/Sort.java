package com.morsu.sorting;

import com.morsu.utils.AlgoUtils;

public abstract class Sort {

    abstract void sort(final int[] inputArray);

    public static void run(Sort instance) {
        int[] inputArray = AlgoUtils.getInputArray();
        System.out.print("Before Sorting: ");
        AlgoUtils.printArray(inputArray);
        instance.sort(inputArray);
        System.out.print("After Sorting: ");
        AlgoUtils.printArray(inputArray);
    }
}
