package GKG.Array;

import java.util.Arrays;

public class FindMinimumElementInRotatedSortedArray {

    private static final int NOT_FOUND = -1;

    public static void main(String[] args) {
        int[] sortedRotatedArray1 = {4, 5, 6, 1, 2, 3, };
        int[] sortedRotatedArray2 = {12, 16, 4, 5, 6, 7, 9};
        int[] sortedRotatedArray3 = {3, 9, 12, 16};
        int[] sortedRotatedArray4 = {3, 9, 12, 16, 17, 2};

        System.out.println("Soreted Array1 :: "+ Arrays.toString(sortedRotatedArray1)+" :: "+ " Min element :: "+ findMinElement(sortedRotatedArray1));
        System.out.println("Soreted Array2 :: "+ Arrays.toString(sortedRotatedArray2)+" :: Min element :: "+ findMinElement(sortedRotatedArray2));
        System.out.println("Soreted Array3 :: "+ Arrays.toString(sortedRotatedArray3)+" :: Min element :: "+ findMinElement(sortedRotatedArray3));
        System.out.println("Soreted Array4 :: "+ Arrays.toString(sortedRotatedArray4)+" ::  Min element :: "+ findMinElement(sortedRotatedArray4));

    }

    private static int findMinElement(int[] sortedRotatedArray) {
        int arrayLength = sortedRotatedArray.length;
        if (arrayLength == 0) {
            return NOT_FOUND;
        }

        int left = 0;
        int right = arrayLength - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            // Check if the mid key has the pivot rotated point.
            if (!(sortedRotatedArray[mid] > sortedRotatedArray[mid - 1]) || !(sortedRotatedArray[mid] < sortedRotatedArray[mid + 1])) {
                // The min value will be in either left  sorted array or right sorted array.
                return sortedRotatedArray[left] < sortedRotatedArray[mid+1] ? sortedRotatedArray[left] : sortedRotatedArray[mid+1];
            } else {
                // Check if sorting is on left or right.
                if (sortedRotatedArray[mid] < sortedRotatedArray[left]) {
                    right = mid;
                } else if(sortedRotatedArray[mid] > sortedRotatedArray[right]){
                    left = mid;
                } else {
                    break;
                }
            }


        }

        return sortedRotatedArray[0];
    }
}
