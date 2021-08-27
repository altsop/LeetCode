package data_structures.maximum_subarray;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/maximum-subarray/
public class Solution {

    // time complexity O(n)

    // Follow up: If you have figured out the O(n) solution,
    // try coding another solution using the divide and conquer approach, which is more subtle.
    public int maxSubArray(int[] nums) {
        // we cannot sort because this part has to be a contiguous part of the initial array
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int currentIndex = 0;

        while (currentIndex < nums.length) {
            sum += nums[currentIndex];
            if (sum > max) {
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }

            currentIndex++;
        }

        return sum;
    }

    public static void main(String[] args) {

    }

}
