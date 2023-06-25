package year_2022.medium_46;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        findPermutations(
                nums,
                result,
                0,
                new ArrayList<>()
        );

        return result;
    }

    private void findPermutations(int[] nums, List<List<Integer>> result, int index, List<Integer> permutation) {
        if (permutation.size() == nums.length) {
            result.add(new ArrayList<>(permutation));
            return;
        }

        int i = index;
        do {
            List<Integer> copy = new ArrayList<>(permutation);
            int element = nums[i % nums.length];
            if (!copy.contains(element)) {
                copy.add(element);
            }

            if (copy.size() != permutation.size()) {
                findPermutations(
                        nums,
                        result,
                        index + 1,
                        copy
                );
            }
            i++;

        } while (index != i % nums.length);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.permute(new int[]{1, 2, 3});
    }
}
