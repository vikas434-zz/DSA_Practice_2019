package leetCodeTop100Liked.medium;

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
     public int findDuplicate(int[] nums) {
        int length = nums.length;
        int expectedSum = (length * (length +1))/2;
        int totalSum = 0;
        for(int i = 0; i< length; i++) {
            totalSum += nums[i];
        }
        int lastSum = expectedSum - length;
        return totalSum - lastSum;
    }
}
