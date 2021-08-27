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

        // nums<starting index of substring, sum>
        Map<Integer, Integer> sums = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int sum = sums.get(i) != null ? sums.get(i) : 0;
            sums.put(i, sum + nums[i]);
        }
    }

}
