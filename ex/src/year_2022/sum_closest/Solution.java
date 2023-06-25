package year_2022.sum_closest;

import java.util.Arrays;

// https://leetcode.com/problems/3sum-closest/submissions/
public class Solution {

    // time complexity = O(n^2)
    // space complexity = O(1)
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                int diff = Math.abs(sum - target);
                if (diff == 0) {
                    return sum;
                }
                if (diff < minDiff) {
                    minDiff = diff;
                    result = sum;
                }

                if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.threeSumClosest(new int[]{1, 1, -1, -1, 3}, -1)); // -1
        System.out.println(solution.threeSumClosest(new int[]{0, 2, 1, -3}, 1)); // 0
        System.out.println(solution.threeSumClosest(new int[]{0, 1, 2}, 1)); // 3
        System.out.println(solution.threeSumClosest(new int[]{-1, 2, 1, -4}, 1)); // 2
        System.out.println(solution.threeSumClosest(new int[]{0, 0, 0}, 1)); // 0
    }

}
