package LeetCode;

/**
 * Return the length of the shortest, non-empty, contiguous subarray of A with sum at least K.
 *
 * If there is no non-empty subarray with sum at least K, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: A = [1], K = 1
 * Output: 1
 * Example 2:
 *
 * Input: A = [1,2], K = 4
 * Output: -1
 * Example 3:
 *
 * Input: A = [2,-1,2], K = 3
 * Output: 3
 *
 *
 * Note:
 *
 * 1 <= A.length <= 50000
 * -10 ^ 5 <= A[i] <= 10 ^ 5
 * 1 <= K <= 10 ^ 9
 */
public class ShortestSubArrayWithSumAtLeastK {


    public int shortestSubarray(int[] A, int K) {
        final int NOT_FOUND = -1;

        // Use Kadane's algorithm to solve this. Not sure, if it will give the correct result.
        boolean isSubStringFound = false;
        int maxHere = 0;
        int size = A.length;
        int maxLengthOfSubString = 0;

        for (int i = 0; i < size; i++) {
            if (A[i] + maxHere > 0) {
                maxHere = A[i] + maxHere;
                if (maxHere >= K) {
                    maxLengthOfSubString = i + 1;
                    break;
                }
            }
        }

        // Find possibility within that max length.
        int counter = 0;
        int sum = 0;
        for (int j = maxLengthOfSubString - 1; j >= 0; j--) {
            // Keep updating sum till it reaches K.
            sum = sum + A[j];
            counter++;
            if (sum >= K || j==0) {
                isSubStringFound = true;
                break;
            }

        }

        if (isSubStringFound) {
            return counter;
        } else {
            return NOT_FOUND;
        }
    }
}
