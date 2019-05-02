package LeetCode;

/**
 * Given an array nums of n integers where n > 1,  return an array output such that output[i]
 * is equal to the product of all the elements of nums except nums[i].
 * <p>
 * Example:
 * <p>
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Note: Please solve it without division and in O(n).
 * <p>
 * Follow up:
 * Could you solve it with constant space complexity? (
 * The output array does not count as extra space for the purpose of space complexity analysis.)
 */

public class ProductExceptSelf {
    /**
     * Approach 1:- Find the left[i] at i containing all the left multiplication. Do same with right[i]
     */
    public int[] productExceptSelf(int[] nums) {

        int size = nums.length;

        int[] output = new int[size];
        int[] left = new int[size];
        int[] right = new int[size];

        int temp = 1;
        // Start filling up left array
        for (int i = 0; i < size; i++) {
            left[i] = temp;
            temp = temp * nums[i];
        }

        // Again set the temp to 1
        temp = 1;

        // Start filling up right array
        for (int i = size - 1; i >= 0; i--) {
            right[i] = temp;
            temp = temp * nums[i];
        }

        // Final traversal and return sum array.
        for (int i = 0; i < size; i++) {
            output[i] = left[i] * right[i];
        }

        return output;
    }
}
