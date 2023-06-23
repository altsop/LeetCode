package meidum_40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        final List<List<Integer>> result = new ArrayList<>();
        findPermutations(
                candidates,
                target,
                result,
                new ArrayList<>(),
                0
        );

        return result;
    }

    private void findPermutations(int[] candidates, int target, List<List<Integer>> result, List<Integer> permutation, int index) {
        int sum = calculateSum(permutation);
        if (sum > target) {
            return;
        } else if (sum == target) {
            result.add(permutation);
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i != index && candidates[i] == candidates[i - 1]) {
                continue;
            }

            int element = candidates[i];
            if (element > target) {
                return;
            }

            List<Integer> copy = new ArrayList<>(permutation);
            copy.add(element);
            findPermutations(
                    candidates,
                    target,
                    result,
                    copy,
                    i + 1
            );
        }
    }

    private int calculateSum(List<Integer> permutation) {
        return permutation.stream().reduce(Integer::sum).orElse(0);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.combinationSum2(
                new int[]{10, 1, 2, 7, 6, 1, 5},
                8
        );
        solution.combinationSum2(
                new int[]{2, 5, 2, 1, 2},
                5
        );
    }

}
