package leetCodeTop100Liked.medium;

/**
 * @author vranjan
 * created 03/11/2021
 *
 * // nums = [1,1,1], k = 2
 */
public class P560SubArraySum {
    public int subarraySum(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        int options = 0;
        int totalSum = 0;

        // Using brute force
        for (int i = 0; i < nums.length; i++) {
            totalSum = nums[i];
            for (int m = i+1; m < nums.length; m++) {
                totalSum += nums[m];
                if (totalSum == k) {
                    options++;
                    break;
                }
                else if (totalSum > k) {
                    break;
                }
            }
        }

        // For last boundary case
        if(nums[nums.length-1] == k) {
            options++;
        }

        return options;
    }
    // This solution fails for the use case -> [1,-1,0] , 0 ; Output 2 but expected 3 -> why??
}
