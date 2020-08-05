package leetCodeTop100Liked.medium;

import java.util.Arrays;

/**
 * Created by Vikas Ranjan on 2020-08-05
 *
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Example 1:
 *
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * Example 2:
 *
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class P215KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        int length = nums.length;
        if(length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        return nums[length-k];
    }
}
// This solution is with nlogn, look out for something in logn.
