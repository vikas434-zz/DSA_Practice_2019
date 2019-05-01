package LeetCode;

public class MaxProfitBySellingShareOneMaxOnePass {

    public int maxProfit(int[] prices) {
        int size = prices.length;

        if(size == 0 || size == 1) {
            return 0;
        }

        int maxProfit = 0;

        for(int i =0; i<size-1; i++) { // Going till size -1 because, we are comparing next element
            // Check if it valley or peak
            if(isPeak(i, prices)) {
                maxProfit += getPeak(i, prices);
            }
        }

        return maxProfit;
    }

    private boolean isPeak(int i, int[] prices) {
        return prices[i+1] > prices[i];
    }

    private int getPeak(int i, int[] prices) {
        return (prices[i+1] - prices[i]);
    }
}
