package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *
 * You must write an algorithm that runs in O(n) time.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * Example 2:
 *
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 *
 * Note :-
 *
 * Approach 1:- sorting option works fine but fails when we have more than one repeated element in between e.g. [0,2,1,1]
 */

public class P128LongestConsequiteveSubsequence {

    public static void main(String[] args) {
        int[] nums= {0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive2(nums));
    }

    // Approach 1 has issue with duplicate numbers - that too in middle.
    public static int longestConsecutive1(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        // Approach 1 :- sort and keep the counter.
    // [0,3,7,2,5,8,4,6,0,1]
        Arrays.sort(nums); //nlogn complexity
        // [0,0,1,2,3,4,5,6,7,8]

        int maxSubSequenceLength = 1;

        int i = 0;
        int counter = 1;
        while (i<nums.length-1) {
            if(nums[i] == nums[i+1]-1) {
                counter++;
            } else {
                maxSubSequenceLength = Math.max(maxSubSequenceLength, counter);
                counter = 1;
            }
            i++;
        }
        maxSubSequenceLength = Math.max(maxSubSequenceLength, counter);
        return maxSubSequenceLength;
    }

    // Approach 2 :- using set
    public static int longestConsecutive2(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new TreeSet<Integer>();
        for (int n: nums) {
            set.add(n);
        }

        Integer[] sortedArray = set.toArray(new Integer[set.size()]);


        int maxSubSequenceLength = 1;

        int i = 0;
        int counter = 1;
        while (i<sortedArray.length-1) {
            if(sortedArray[i] == sortedArray[i+1]-1) {
                counter++;
            } else {
                maxSubSequenceLength = Math.max(maxSubSequenceLength, counter);
                counter = 1;
            }
            i++;
        }
        maxSubSequenceLength = Math.max(maxSubSequenceLength, counter);
        return maxSubSequenceLength;
    }

    // Approach 3 :- No need to keep a sorted set, just skip the duplicate numbers.

}
