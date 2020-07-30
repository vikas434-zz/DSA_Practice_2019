package leetCodeTop100Liked.easy;

/* Created by Vikas Ranjan on 2020-07-25
 *
 */
public class P70ClimbingStairs {

    public int climbStairs(int n) {
        if(n == 0) {
            return 0;
        }
        if(n==1) {
            return 1;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;

        for(int i = 2; i < n; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }

        return dp[n-1];

    }
}

/**
 * At any stairs(except base case), it is combination of last two stairs.
 */
