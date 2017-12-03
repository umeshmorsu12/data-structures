package com.morsu.sorting;


import com.morsu.utils.AlgoUtils;

/*
      Bubble sort sorts numbers by comparing with adjacent number and swap.
      This process continues till no more passes left

      Worst-case performance	    O(n^2)
      Best-case performance	        O(n)
      Average performance	        O(n^2)
      Worst-case space complexity	O(1)

 */
public class BubbleSort  extends Sort {

    public void sort(final int[] inputArray) {

        boolean swapFlag = true;
        int length = inputArray.length;

        // If swap flag is true, just run the program till there is no more swapping
        while(swapFlag) {
            System.out.println("------------- START PASS --------------");
            swapFlag = false;
            for (int index = 0; index < length-1; index++) {

                if (inputArray[index] > inputArray[index+1]) {

                    int temp = inputArray[index];
                    inputArray[index] = inputArray[index+1];
                    inputArray[index+1] = temp;

                    swapFlag = true;
                }
            }
            System.out.print("Pass Result# ");
            AlgoUtils.printArray(inputArray);
            System.out.println("------------- END PASS --------------");
        }
    }

    public static void main(String args[]) {
        run(new BubbleSort());
    }

}
