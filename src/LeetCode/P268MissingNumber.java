package LeetCode;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 *
 * Example 1:
 *
 * Input: [3,0,1]
 * Output: 2
 * Example 2:
 *
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */
public class P268MissingNumber {
    public int missingNumber1(int[] nums) {
        int size = nums.length;

        if(size == 0) {
            return 0;
        }

        boolean[] numPresent = new boolean[size+1];

        for(int i = 0; i<size; i++) {
            numPresent[nums[i]] = true;
        }

        for(int j =0; j<numPresent.length; j++) {
            if(numPresent[j] == false) {
                return j;
            }
        }

        return 0;
    }

    /**
     * Using gauss formula sum of n is n*n+1/2
     */
    public int missingNumber(int[] nums) {
        int size = nums.length;

        if (size == 0) {
            return 0;
        }

        int totalSum = (size * (size + 1)) / 2;

        int actualSum = 0;

        for (int num : nums) {
            actualSum += num;
        }

        return totalSum - actualSum;
    }
}
