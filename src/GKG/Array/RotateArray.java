package GKG.Array;

import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        int[] array1 = {1,2,3,4,5,6};
        int[] array2 = {1,2,3,4,5,6,7};

        System.out.println("Original array 1 "+ Arrays.toString(array1)+ " :: After rotation by 2 "+" ::: "+Arrays.toString(rotateArray(array1, 2, 6)));
        System.out.println("Original array 2 "+ Arrays.toString(array2)+ " :: After rotation by 3 "+" ::: "+Arrays.toString(rotateArray(array2, 3, 7)));
    }

    public static int[] rotateArray(int[] array, int rotateBy, int arrayLength) {
        if(array.length <= 1) {
            return array;
        }

        int temp;
        for(int i =0; i<rotateBy; i++) {
            temp = array[0];
            // Move all to next left except last one.
            for(int j =0; j<arrayLength-1; j++) {
                array[j] = array[j+1];
            }
            array[arrayLength-1] = temp;
        }
        return array;
    }
}
