package best_time_to_buy_and_sell;

public class Solution {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        Integer minPrice = null;

        for (int buyDayIndex = 0; buyDayIndex < prices.length; buyDayIndex++) {
            int buyPrice = prices[buyDayIndex];
            if (minPrice == null || minPrice > buyPrice) {
                minPrice = buyPrice;

                for (int sellDayIndex = buyDayIndex + 1; sellDayIndex < prices.length; sellDayIndex++) {
                    int profit = prices[sellDayIndex] - buyPrice;
                    maxProfit = Math.max(profit, maxProfit);
                }
            }
        }

        return maxProfit;
    }

}
