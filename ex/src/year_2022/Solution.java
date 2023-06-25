package year_2022.three_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        findAllPermutations(
                nums,
                0,
                result,
                new HashMap<>(),
                new ArrayList<>()
        );

        return result;
    }

    private void findAllPermutations(int[] nums, int index, List<List<Integer>> result, Map<Integer, Set<Integer>> pairs, List<Integer> permutation) {
        for (int i = index; i < nums.length; i++) {
            int current = nums[i];
            List<Integer> copy = new ArrayList<>(permutation);
            copy.add(current);

            if (copy.size() >= 2) {
                final Set<Integer> integers = pairs.get(copy.get(0));
                if (integers != null && integers.contains(copy.get(1))) {
                    continue;
                }
            }

            int sum = calculateSum(copy);
            if (copy.size() == 3 && sum == 0) {
                result.add(copy);

                add(
                        pairs,
                        copy.get(0),
                        copy.get(1)
                );
                add(
                        pairs,
                        copy.get(1),
                        copy.get(2)
                );
                add(
                        pairs,
                        copy.get(2),
                        copy.get(0)
                );
                return;
            } else if (sum <= 0) {
                int k = 0;
                if (copy.size() == 2) {
                    int closestIndex = binarySearch(
                            nums,
                            sum,
                            i + 1
                    );
                    if (closestIndex == -1) {
                        continue;
                    }
                    k = closestIndex - i - 1;
                }
                findAllPermutations(
                        nums,
                        i + 1 + k,
                        result,
                        pairs,
                        copy
                );
            } else {
                return;
            }
        }
    }

    private void add(Map<Integer, Set<Integer>> map, int a, int b) {
        Set<Integer> set = map.get(a);
        if (set == null) {
            set = new HashSet<>();
        }

        set.add(b);
        map.put(a, set);
    }

    private int binarySearch(int[] nums, int sumOfTwo, int start) {
        int target = -sumOfTwo;

        int left = start;
        int right = nums.length - 1;
        int pivot = 0;
        while (left <= right) {
            pivot = calculatePivot(
                    left,
                    right
            );

            int pivotElement = nums[pivot];
            if (pivotElement < target) {
                left = pivot + 1;
            } else if (pivotElement > target) {
                right = pivot - 1;
            } else {
                return pivot;
            }
        }

        return -1;
    }

    private int calculateSum(List<Integer> permutation) {
        return permutation.stream().reduce(Integer::sum).orElse(0);
    }

    private int calculatePivot(int left, int right) {
        return left + (right - left) / 2;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.threeSum(new int[]{0, 0, 0, 0}));
        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4}));
        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(solution.threeSum(new int[]{-2, 0, 1, 1, 2}));
        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4}));
//        System.out.println(solution.threeSum(new int[]{-5, 14, 1, -2, 11, 11, -10, 3, -6, 0, 3, -4, -9, -13, -8, -7, 9, 8, -7, 11, 12, -7, 4, -7, -1, -5, 13, 1, -2, 8, -13, 0, -1, 3, 13, -13, -1, 10, 5, 1, -13, -15, 12, -7, -13, -11, -7, 3, 13, 1, 0, 2, 1, 11, 10, 8, -8, 1, -14, -3, -6, -12, 12, 0, 6, 2, 2, -9, -3, 14, -1, -9, 14, -4, -1, 8, -8, 7, -4, 12, -14, 3, -9, 2, 0, -13, -13, -1, 3, -12, 11, 4, -9, 8, 11, 5, -5, -10, 3, -1, -11, -13, 5, -12, -10, 11, 11, -3, -5, 14, -13, -4, -5, -7, 6, 2, -13, 0, 8, -3, 4, 4, -14, 2}));
//        System.out.println(solution.threeSum(new int[]{-10, -7, -3, -9, -8, -9, -5, 6, 0, 6, 4, -15, -12, 3, -12, -10, -5, -5, 2, -4, 13, 8, -9, 6, -11, 11, 3, -13, -3, 14, -9, 2, 14, -5, 8, -9, -7, -12, 5, 1, 2, -6, 1, 5, 4, -4, 3, 7, -2, 12, 10, -3, 6, -14, -12, 10, 12, 7, 12, -14, -2, 11, 4, -10, 13, -11, -4, -8, -15, -14, 8, -6, -12, -14, 6, 7, -3, -14, -1, 11, 14, -6, -15, 5, -13, -12, 0, 14, 2, -11, -14, 8, -15, -3, 13, 14, -7, -14, 13, -15, 10, -2, -14, 13}));
    }

// [[-4,0,4],[-4,1,3],[-3,-1,4],[-3,0,3],[-3,1,2],[-2,-1,3],[-2,0,2],[-1,-1,2],[-1,0,1]]
// [[-2, -1, 3], [-2, 0, 2], [-1, -1, 2], [-1, 0, 1]]
}
