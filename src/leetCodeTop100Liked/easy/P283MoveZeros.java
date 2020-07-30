package leetCodeTop100Liked.easy;

/**
 * Created by vranjan on 2020-07-14
 *
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
public class P283MoveZeros {

    public void moveZeroes(int[] nums) {
        if (nums.length <= 1) {
            return;
        }

        int zeroCount = 0;

        int currentZeroIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            }
            else {
                nums[currentZeroIndex++] = nums[i];
            }
        }

        // fill all the zeros at last
        int length = nums.length;
        if (zeroCount > 0) {
            int remainingValue = length - zeroCount;
            for (int j = remainingValue; j < length; j++) {
                nums[j] = 0;
            }
        }
    }
}
