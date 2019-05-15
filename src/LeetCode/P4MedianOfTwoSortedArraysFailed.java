package LeetCode;


import java.util.LinkedList;
import java.util.List;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Example 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 * Example 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 */
public class P4MedianOfTwoSortedArraysFailed {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median = 0.0;

        int size1 = nums1.length;
        int size2 = nums2.length;

        if (size1 == 0 && size2 == 0) {
            return median;
        }
        int[] insertedArray;
        if (size1 == 0) {
            return getMedian(nums2);
        } else if (size2 == 0) {
            return getMedian(nums1);
        } else if(size1 > size2) {
            insertedArray = insert(nums1, nums2);
        } else {
            insertedArray = insert(nums2, nums1);
        }
        return getMedian(insertedArray);

    }

    private int[] insert(int[] nums1, int[] nums2) {
        int size1 = nums1.length;
        int size2 = nums2.length;

        List<Integer> insertedList = new LinkedList<>();
        // TODO :- idea is to put keep inserting nums2 in  num1 by doing binary search. But inserting in O[1) is not supported????
        return new int[0];
    }

    private double getMedian(int[] arr) {
       int size = arr.length;

       if(size%2 == 0) {
           return (arr[size/2] + arr[(size/2) -1])/2;
       } else {
           return arr[size/2];
       }
    }
}
