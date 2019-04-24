package GKG.Array;

import java.util.Arrays;

public class RotateArrayByReverse {
    public static void main(String[] args) {
        int[] array1 = {1,2,3,4,5,6};
        int[] array2 = {1,2,3,4,5,6,7};

        System.out.println("Original array 1 "+ Arrays.toString(array1)+ " :: After rotation by 2 "+" ::: "+Arrays.toString(rotateArray(array1, 2, 6)));
        System.out.println("Original array 2 "+ Arrays.toString(array2)+ " :: After rotation by 3 "+" ::: "+Arrays.toString(rotateArray(array2, 3, 7)));
    }

    public static int[] rotateArray(int[] array, int rotateBy, int arrayLength) {
        if(array.length <= 1 || rotateBy > arrayLength) {
            return array;
        }

        int temp;
        reverse(array, 0, rotateBy);
        reverse(array, rotateBy, arrayLength);
        reverse(array, 0, arrayLength);
        return array;
    }

    private static void reverse(int[] array, int start, int last) {
        int temp = 0;
        while (start < last) {
            temp = array[start];
            array[start] = array[last-1];
            array[last-1] = temp;
            start++;
            last--;
        }
    }
}
