package year_2023.medium_47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        findPermutations(
                nums,
                result,
                new ArrayList<>(),
                0
        );
        return result;
    }

    private void findPermutations(int[] nums, List<List<Integer>> result, List<Integer> permutationIndexes, int index) {
        if (permutationIndexes.size() == nums.length) {
            var permutation = permutationIndexes.stream().map(i -> nums[i]).toList();
            result.add(permutation);
            return;
        }

        int initial = index;
        do {
            if (index != initial && nums[index % nums.length] == nums[(index - 1) % nums.length]) {
                index++;
                continue;
            }

            if (!permutationIndexes.contains(index % nums.length)) {
                List<Integer> copy = new ArrayList<>(permutationIndexes);
                copy.add(index % nums.length);
                findPermutations(
                        nums,
                        result,
                        copy,
                        (index + 1) % nums.length
                );
            }

            index++;
        } while (index % nums.length != initial);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.permuteUnique(new int[]{1, 1, 2});
    }

}
