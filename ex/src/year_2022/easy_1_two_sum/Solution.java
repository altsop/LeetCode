package year_2022.easy_1_two_sum;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        finish:
        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int second = nums[j];
                if (first + second == target) {
                    result[0] = i;
                    result[1] = j;
                    break finish;
                }
            }
        }
        return result;
    }

}
