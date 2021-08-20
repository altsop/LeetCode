package easy_1_two_sum;

import java.util.HashMap;
import java.util.Map;


/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 */
public class Solution2 {

        public int[] twoSum(int[] nums, int target) {
            // <difference from target, index in nums>
            Map<Integer, Integer> differences = new HashMap<>();
            int[] result = new int[2];

            for (int i = 0; i < nums.length; i++) {
                int difference = target - nums[i];

                int missingPart = target - difference;
                if (differences.containsKey(missingPart)) {
                    result[0] = differences.get(missingPart);
                    result[1] = i;
                    break;
                }

                differences.put(difference, i);
            }

            return result;
        }

}
