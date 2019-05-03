package LeetCode;

import java.util.HashMap;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class P1TwoSum {

    public int[] twoSum(int[] nums, int target) {

        int[] output = new int[2];
        if(nums.length <=1) {
            return output;
        }

        int index1 = -1;
        int index2 = -1;

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for(int i =0; i<nums.length; i++) {
            int requiredSum = target - nums[i];
            if(hashMap.get(requiredSum) != null) {
                index1 = hashMap.get(requiredSum);
                index2 = i;
                break;
            }
            hashMap.put(nums[i], i);
        }

        output[0] = index1;
        output[1] = index2;
        return output;

    }
}
