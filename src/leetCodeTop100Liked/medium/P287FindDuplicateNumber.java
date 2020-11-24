package leetCodeTop100Liked.medium;

import java.util.Arrays;

/**
 * Created by vranjan on 2020-11-06
 * 
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 *
 * There is only one duplicate number in nums, return this duplicate number.
 *
 * Follow-ups:
 *
 * How can we prove that at least one duplicate number must exist in nums? 
 * Can you solve the problem without modifying the array nums?
 * Can you solve the problem using only constant, O(1) extra space?
 * Can you solve the problem with runtime complexity less than O(n2)?
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 * Example 2:
 *
 * Input: nums = [3,1,3,4,2]
 * Output: 3
 * Example 3:
 *
 * Input: nums = [1,1]
 * Output: 1
 * Example 4:
 *
 * Input: nums = [1,1,2]
 * Output: 1
 */
//TODO
public class P287FindDuplicateNumber {
    // Scenario 1 -- not working
//     public int findDuplicate(int[] nums) {
//        int length = nums.length;
//        int expectedSum = (length * (length +1))/2;
//        int totalSum = 0;
//        for(int i = 0; i< length; i++) {
//            totalSum += nums[i];
//        }
//        int lastSum = expectedSum - length;
//        return totalSum - lastSum;
//    }
    
    // [3,1,3,4,2] -> [1,2,3,3,4]
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1; i< nums.length; i++) {
            if(nums[i] == nums[i-1]) {
                return nums[i];
            }
        }
        return -1;
    }
    
    
}

// Mistake :- the duplicate case like [2,2,2,2] is not taken care in the above scenario. - 1

// Other possible solution is to use Set or use pigeon hole principle.