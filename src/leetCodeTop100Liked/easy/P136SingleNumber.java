package leetCodeTop100Liked.easy;

/**
 * Created by vranjan on 2020-07-13
 *
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
    //    public int singleNumber(int[] nums) {
    //        if (nums.length == 0) {
    //            return 0;
    //        }
    //
    //        // For even length integer
    //        if (nums.length % 2 == 0) {
    //            return 0;
    //        }
    //
    //        Set<Integer> set = new HashSet<>();
    //        for (final int num : nums) {
    //            if (set.contains(num)) {
    //                set.remove(num);
    //            }
    //            else {
    //                set.add(num);
    //            }
    //        }
    //
    //        return set.iterator().hasNext() ? set.iterator().next() : 0;
    //
    //
    //    }

    // Approach 2 
    public int singleNumber(int[] nums) {
        int a = 0;
        for (int x : nums) {
            a ^= x;
        }
        return a;

    }
}
