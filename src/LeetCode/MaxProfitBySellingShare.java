package LeetCode;

public class MaxProfitBySellingShare {

    public int maxProfit(int[] prices) {
        int size = prices.length;

        if(size == 0 || size == 1) {
            return 0;
        }

        int maxProfit = 0;
        // Iterate through each right element.
        for(int i =0; i<size; i++) {
            for(int j = i+1; j<size; j++) {
                if(prices[j] > prices[i]) {
                    int diff = prices[j] - prices[i];
                    if(diff > maxProfit) {
                        maxProfit = diff;
                    }
                }
            }
        }

        return maxProfit;
    }
}
