package LeetCode;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 *
 * Input: [2,2,1]
 * Output: 1
 * Example 2:
 *
 * Input: [4,1,2,1,2]
 * Output: 4
 */
public class P136SingleNumber {
    public int singleNumber(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        int answer = 0;

        // In java N^N = 0 and N^0 = N. Xoring all element will give the missing element.
        for(int num : nums) {
            answer = answer^num;
        }

        return answer;
    }
}
