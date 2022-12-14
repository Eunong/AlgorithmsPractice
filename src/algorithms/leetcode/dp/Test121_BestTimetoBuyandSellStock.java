package algorithms.leetcode.dp;

public class Test121_BestTimetoBuyandSellStock {
    public static int maxProfit(int[] prices) {
        int min = prices[0];
        int maxProfit = 0;

        for(int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i]-min);

            min = Math.min(min, prices[i]);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println("TestCase1 : " + maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println("TestCase2 : " + maxProfit(new int[]{7,6,4,3,1}));
    }
}
