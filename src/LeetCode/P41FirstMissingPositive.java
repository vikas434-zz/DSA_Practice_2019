package LeetCode;

import java.util.Arrays;

/**
 * Given an unsorted integer array, find the smallest missing positive integer.
 *
 * Example 1:
 *
 * Input: [1,2,0]
 * Output: 3
 * Example 2:
 *
 * Input: [3,4,-1,1]
 * Output: 2
 * Example 3:
 *
 * Input: [7,8,9,11,12]
 * Output: 1
 * Note:
 *
 * Your algorithm should run in O(n) time and uses constant extra space.
 */
public class P41FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        if(nums.length == 1) {
            if(nums[0] <=0) {
                return 1;
            } else {
                return ++nums[0];
            }
        }
        Arrays.sort(nums);

        int i =0;
        while(i <= nums.length -1) {
            if(nums[i] > 0) {
                break;
            }
            i++;
        }
        // Got first positive integer.
        System.out.println("i is "+i);
        while(i <=nums.length-2) {
            if(nums[i+1] != nums[i]+1) {
                return nums[i] + 1;
            }
            i++;
        }
        if(nums[i] <=0) {
            return 1;
        } else {
            return nums[i]+1;
        }
    }
}
