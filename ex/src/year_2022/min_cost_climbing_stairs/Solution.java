package year_2022.min_cost_climbing_stairs;

public class Solution {

    public int minCostClimbingStairs(int[] cost) {
        int[] minimumCost = new int[cost.length];
        minimumCost[0] = cost[0];
        minimumCost[1] = cost[1];

        for (int i = 2; i < cost.length; i++) {
            minimumCost[i] = cost[i] + Math.min(minimumCost[i - 1], minimumCost[i - 2]);
        }

        return Math.min(minimumCost[cost.length - 1], minimumCost[cost.length - 2]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minCostClimbingStairs(new int[]{10, 15, 20}));
        System.out.println(solution.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }

    // [1,100,1,1,1,100,1,1,100,1]
    //  1 100 2 3 3 103 4 5 104 6
}
