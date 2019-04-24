package GKG.Array;

import java.util.Arrays;

public class FindElementInSortedRotatedArrayBinarySearch {

    public static void main(String[] args) {
        int[] sortedArray1 = {4, 5, 6, 1, 2, 3, };
        int[] sortedArray2 = {12, 16, 4, 5, 6, 7, 9};
        int[] sortedArray3 = {12, 16, 3, 9};

        System.out.println("Soreted Array1 :: "+ Arrays.toString(sortedArray1)+" :: to find 2, index returned :: "+findElementIndex(sortedArray1, 2));
        System.out.println("Soreted Array2 :: "+ Arrays.toString(sortedArray2)+" :: to find12, index returned :: "+findElementIndex(sortedArray2, 12));
        System.out.println("Soreted Array3 :: "+ Arrays.toString(sortedArray3)+" :: to find 2, index returned :: "+findElementIndex(sortedArray3, 2));

        System.out.println("Need better solution!!");
    }

    public static int findElementIndex(int[] array, int toSearch) {
        int rotatedPivotIndex = findRotatedPivotIndex(array);
        int arrayLength = array.length;
        if(rotatedPivotIndex == -1) {
            System.out.println("Array is already sorted");
            return searchInSortedArray(array, toSearch);
        } else {
            // Sort the array first.
            rotateArray(array, 0, rotatedPivotIndex);
            rotateArray(array, rotatedPivotIndex+1, arrayLength-1);
            rotateArray(array, 0, arrayLength-1);
            // Now array is sorted.
            System.out.println("Sorted array :: "+Arrays.toString(array));
            return searchInSortedArray(array, toSearch);
        }

    }

    public static void rotateArray(int[] array, int start, int end) {
        if(array.length <=1 || start > end) {
            return;
        }
        int temp = 0;
        while (start < end) {
            temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    public static int findRotatedPivotIndex(int[] array) {
        int NOT_FOUND = -1;
        int length = array.length;
        if(length <=1) {
            return NOT_FOUND;
        }

        for(int i =0; i< length-1; i++) {
            if(array[i] > array[i+1]) {
                return i;
            }
        }
        return NOT_FOUND;
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
