package two_sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valueToIndex = new HashMap<>();
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int currentValue = nums[i];
            int missingPart = target - currentValue;
            if (valueToIndex.get(missingPart) != null) {
                result[0] = i;
                result[1] = valueToIndex.get(missingPart);
                break;
            }

            valueToIndex.put(currentValue, i);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.twoSum(new int[]{2, 7, 11, 15}, 9))); // 1 0
        System.out.println(Arrays.toString(solution.twoSum(new int[]{3,2,4}, 6))); // 2 1
    }

}
