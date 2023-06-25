package year_2022.combination_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // naive -> recursively find all permutations -> choose appropriate ones
        // optimization: stop if sum > 7

        // candidates = [2,3,6,7], target = 7
        // target = 7
        // 1: 7 - 2 = 5 -> target = 5
        // 1.1: 5 - 2 = 3 -> target = 3
        // 1.1.1: 3 - 3 = 0 -> combination is found

        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();
        composeCombination(
                target,
                new ArrayList<>(),
                candidates,
                0,
                result
        );

        return result;
    }

    private void composeCombination(int target, List<Integer> combination, int[] candidates, int index, List<List<Integer>> result) {
        if (target == 0) {
            result.add(combination);
            return;
        }

        int smallest = candidates[0];
        if (target < smallest) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            final int candidate = candidates[i];
            List<Integer> updatedCombination = new ArrayList<>(combination);
            updatedCombination.add(candidate);

            int updatedTarget = target - candidate;
            if (updatedTarget != 0 && updatedTarget < smallest) {
                continue;
            }

            composeCombination(
                    target - candidate,
                    updatedCombination,
                    candidates,
                    i,
                    result
            );
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.combinationSum(
//                new int[]{2, 3, 5},
//                8
//        );
        solution.combinationSum(
                new int[]{2, 3, 6, 7},
                7
        );
    }

}
