package running_sum_of_1d_array;

import java.util.Arrays;

// https://leetcode.com/problems/running-sum-of-1d-array/
class Solution {

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public static int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int previous = result[i -1];
            int current = nums[i];
            result[i] = previous + current;
        }

        return result;
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public int[] runningSum2(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            // Result at index `i` is sum of result at `i-1` and element at `i`.
            nums[i] += nums[i - 1];
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(runningSum(new int[]{1, 2, 3, 4}))); // => [1, 3, 6, 10]

    }

}