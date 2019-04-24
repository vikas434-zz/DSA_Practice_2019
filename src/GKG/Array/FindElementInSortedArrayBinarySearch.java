package GKG.Array;

import java.util.Arrays;

public class FindElementInSortedArrayBinarySearch {

    public static void main(String[] args) {
        int[] sortedArray1 = {1, 2, 3, 4, 5, 6};
        int[] sortedArray2 = {4, 5, 6, 7, 9, 12, 16};
        int[] sortedArray3 = {3, 9, 12, 16};

        System.out.println("Soreted Array1 :: "+ Arrays.toString(sortedArray1)+" :: to find 2, index returned :: "+searchInSortedArray(sortedArray1, 2));
        System.out.println("Soreted Array2 :: "+ Arrays.toString(sortedArray2)+" :: to find12, index returned :: "+searchInSortedArray(sortedArray2, 12));
        System.out.println("Soreted Array3 :: "+ Arrays.toString(sortedArray3)+" :: to find 2, index returned :: "+searchInSortedArray(sortedArray3, 2));
    }

    public static int searchInSortedArray(int[] array, int toSearch) {

        int NOT_FOUND = -1;

        int length = array.length;

        if (length == 0) {
            return NOT_FOUND;
        }

        int left = 0;
        int right = length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (array[mid] == toSearch) {
                return mid;
            } else if (array[mid] > toSearch) {
                right = mid;
            } else if (array[mid] < toSearch) {
                left = mid;
            }
        }

        return NOT_FOUND;
    }
}
