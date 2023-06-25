package year_2022.data_structures.two_sum;

import java.util.HashMap;
import java.util.Map;

class Solution {

    // time complexity = O(n)
    // memory complexity = O(n)

    // [2,7,11,15]
    public int[] twoSum(int[] nums, int target) {
        // <difference from the target, index>
        Map<Integer, Integer> differences = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (differences.containsKey(difference)) {
                return new int[]{i, differences.get(difference)};
            }

            differences.put(nums[i], i);
        }
        return new int[]{};
    }

}
