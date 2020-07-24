package leetCodeTop100Liked;

import java.util.HashMap;
import java.util.Map;

/* Created by Vikas Ranjan on 2020-07-24
 *
 *  Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */
public class P1TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] twoSumIndices = new int[2];
        if(nums.length == 0) {
            return twoSumIndices;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++) {
            if(map.containsKey(nums[i])) {
                twoSumIndices[0] = map.get(nums[i]);
                twoSumIndices[1] = i;
                break;
            } else {
                int elementToPut = target - nums[i];
                map.put(elementToPut, i);
            }
        }
        return twoSumIndices;
    }
}
