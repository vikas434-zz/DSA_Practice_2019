package leetCodeTop100Liked;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by vranjan on 2020-07-13
 *
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Example 1:
 *
 * Input: [3,2,3]
 * Output: 3
 * Example 2:
 *
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 */
public class P169MajorityElement {

//    public static int majorityElement(int[] nums) {
//        if (nums.length == 0) {
//            return 0;
//        }
//
//        Map<Integer, Integer> numCountMap = new HashMap<>();
//
//        int majorityElement = 0;
//
//        for (int i : nums) {
//            if (numCountMap.getOrDefault(i, 0) >= nums.length / 2) {
//                majorityElement = i;
//                break;
//            }
//
//            int currentCount = numCountMap.getOrDefault(i, 0);
//            numCountMap.put(i, ++currentCount);
//        }
//
//        return majorityElement;
//    }

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
