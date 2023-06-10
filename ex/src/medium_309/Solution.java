//package medium_309;
//
//public class Solution {
//
//    private static final Integer COOLDOWN = 1;
//
//
//    /**
//     * You are given an array prices where prices[i] is the price of a given stock on the ith day.
//     * <p>
//     * Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:
//     * <p>
//     * After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
//     * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
//     */
//    public int maxProfit(int[] prices) {
//        // naive approach: all permutations
//        // the question is: can we understand that smth was wrong and move back - what is the window?
//
//        // 1 element - always 0 - we cannot sell
//        // 2 elements - check b - a > 0
//        // 3 elements -> (a,b,c) -> b/c = sell. a/b = buy
//        // what is the min window size that gives freedom to make the best step for the next window?
//        // what if 3 + 2? (3 - window; 2 - future to take into consideration
//        // no sense to buy if both profits are negatives
//
//        // base
//        if (prices.length < 2) {
//            return 0;
//        }
//
//        //base
//        if (prices.length == 2) {
//            int gain = prices[1] - prices[0];
//            return Math.max(
//                    gain,
//                    0
//            );
//        }
//
//        // it is memoization -> I need to remember the results of previous sub-problems
//        return deepSearch(0, 0, prices);
//    }
//
//    private Integer deepSearch(int currentResult, int currentDay, int[] prices, int sleepFor) {
//        // it means that all previous sub-problems have been solved optimally, and we don't have any days left
//        if (currentDay == prices.length - 3) {
//            return currentResult;
//        }
//
//
//        // top down with memoization -> we should be able to calculate an optimal values for sub-problems
//        // the result of a sub-problem depends on the future values...
//        //
//        boolean slept = false;
//        for (int i = currentDay; i < prices.length; i++) {
//            int a = prices[i];
//            int b = prices[i + 1];
//            int c = prices[i + 2];
//
//            int ab = b - a;
//            int ac = c - a;
//            int bc = c - b;
//
//            if (ab > 0) {
//
//            }
//
//            if (ac > 0) {
//
//            }
//
//            if (bc > 0) {
//
//            }
//
//            slept = true;
//        }
//    }
//
//    public static void main(String[] args) {
//        Solution solution = new Solution();////////     /  .  /
//        System.out.println(solution.maxProfit(new int[]{1, 2, 3, 0, 2, 100}));
//        //                                                    .
//        System.out.println(solution.maxProfit(new int[]{1, 2, 3, 0, 2, 100}));
//        //                                                       /  .   /
//        System.out.println(solution.maxProfit(new int[]{1, 2, 3, 0, 2, 100}));
//
//
//        // there has to be some flag that allows to decide whether step back is required, or we can adjust only in place
//        //                                              /  .  // .
//        System.out.println(solution.maxProfit(new int[]{1, 2, 3, 10, 2, 100})); // gain = 2
//        //                                                    /  /   .
//        System.out.println(solution.maxProfit(new int[]{1, 2, 3, 10, 2, 100})); // max possible gain = 7, gain = 0 -> make step back and recalculate
//        //
//        System.out.println(solution.maxProfit(new int[]{1, 2, 3, 10, 2, 100}));
//    }
//
//}
