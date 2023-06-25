package year_2022.medium_55;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    Set<Integer> checked = new HashSet<>();

    public boolean canJump(int[] nums) {
        return find(
                nums,
                0
        );
    }

    private boolean find(int[] nums, int index) {
        if (checked.contains(index)) {
            return false;
        }

        if (index == nums.length - 1) {
            return true;
        }

        int step = nums[index];
        for (int i = 1; i <= step; i++) {
            final boolean found = find(
                    nums,
                    index + i
            );

            if (found) {
                return true;
            }
        }

        checked.add(index);
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.canJump(new int[]{3, 2, 1, 0, 4});
    }

}
