package LeetCode;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 *
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class P238MoveZeros {
    public void moveZeroes(int[] nums) {
        if(nums.length <= 1) {
            return;
        }

        int countZero = 0;
        int nonZeroIndex = 0;

        for(int i = 0; i<nums.length; i++) {
            if(nums[i] == 0) {
                countZero++;
            } else {
                nums[nonZeroIndex++] = nums[i];
            }
        }

        if(countZero !=0) {
            for(int j = nums.length-countZero; j<nums.length; j++) {
                nums[j] = 0;
            }
        }
    }
}
