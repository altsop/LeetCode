package data_structures.best_time_to_buy_and_sell_stocks;

class Solution {

        public int maxProfit(int[] prices) {
            int maxProfit = Integer.MIN_VALUE;
            int smallestPrice = Integer.MAX_VALUE;

            // O(n2) = time complexity
            // O(1) = memory
            for (int i = 0; i < prices.length; i++) {
                if (smallestPrice > prices[i]) {
                    smallestPrice = Math.min(smallestPrice, prices[i]);
                    for (int j = i + 1; j < prices.length; j++) {
                        maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
                    };
                }
            }

            return Math.max(maxProfit, 0);
        }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

}
