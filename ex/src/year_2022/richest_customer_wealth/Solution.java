package year_2022.richest_customer_wealth;

import java.util.Arrays;

// https://leetcode.com/problems/richest-customer-wealth/
class Solution {

    /**
     * Time complexity: O(n * m)
     * Space complexity: O(1)
     */
    public static int maximumWealth(int[][] accounts) {
        int maximum = Integer.MIN_VALUE;
        for (int[] account : accounts) {
            int accountWealth = Arrays.stream(account).reduce(0, Integer::sum);
            maximum = Math.max(maximum, accountWealth);
        }

        return maximum;
    }

    public static void main(String[] args) {
        int[][] example = new int[2][3];
        example[0] = new int[]{1,2,3};
        example[1] = new int[]{2,2,3};
        System.out.println(maximumWealth(example));
    }

}
