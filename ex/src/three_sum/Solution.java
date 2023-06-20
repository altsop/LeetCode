package three_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public class Pair {
        final int a;
        final int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public Set<Integer> getSet() {
            Set<Integer> set = new HashSet<>();
            set.add(a);
            set.add(b);

            return set;
        }

        @Override
        public boolean equals(Object obj) {
            Pair pair = (Pair) obj;
            return this.getSet().equals(pair.getSet());
        }

        @Override
        public int hashCode() {
            return 0;
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<Integer> numsList = Arrays.stream(nums).boxed().sorted().toList();
        int max = numsList.get(numsList.size() - 1);

        List<List<Integer>> result = new ArrayList<>();
        findAllPermutations(
                numsList,
                0,
                result,
                new HashSet<>(),
                new ArrayList<>(),
                max
        );

        return result;
    }

    private void findAllPermutations(List<Integer> nums, int index, List<List<Integer>> result, Set<Pair> pairs, List<Integer> permutation, int max) {
        for (int i = index; i < nums.size(); i++) {
            int current = nums.get(i);
            List<Integer> copy = new ArrayList<>(permutation);
            copy.add(current);
            if (copy.size() >= 2) {
                Pair pair = new Pair(
                        copy.get(0),
                        copy.get(1)
                );
                if (pairs.contains(pair)) {
                    continue;
                }
            }

            int sum = calculateSum(copy);
            if (copy.size() == 3 && sum == 0) {
                result.add(copy);

                pairs.add(new Pair(
                        copy.get(0),
                        copy.get(1)
                ));
                pairs.add(new Pair(
                        copy.get(1),
                        copy.get(2)
                ));
                pairs.add(new Pair(
                        copy.get(2),
                        copy.get(0)
                ));
            } else if (copy.size() < 3 && sum <= 0 && !(copy.size() == 2 && sum < -max)) {
                findAllPermutations(
                        nums,
                        i + 1,
                        result,
                        pairs,
                        copy,
                        max
                );
            }
        }
    }

    private int calculateSum(List<Integer> permutation) {
        return permutation.stream().reduce(Integer::sum).orElse(0);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out. println(solution.threeSum(new int[]{0, 0, 0, 0}));
        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4}));
//        System.out.println(solution.threeSum(new int[]{-1,0,1,2,-1,-4}));
//        System.out.println(solution.threeSum(new int[]{-5, 14, 1, -2, 11, 11, -10, 3, -6, 0, 3, -4, -9, -13, -8, -7, 9, 8, -7, 11, 12, -7, 4, -7, -1, -5, 13, 1, -2, 8, -13, 0, -1, 3, 13, -13, -1, 10, 5, 1, -13, -15, 12, -7, -13, -11, -7, 3, 13, 1, 0, 2, 1, 11, 10, 8, -8, 1, -14, -3, -6, -12, 12, 0, 6, 2, 2, -9, -3, 14, -1, -9, 14, -4, -1, 8, -8, 7, -4, 12, -14, 3, -9, 2, 0, -13, -13, -1, 3, -12, 11, 4, -9, 8, 11, 5, -5, -10, 3, -1, -11, -13, 5, -12, -10, 11, 11, -3, -5, 14, -13, -4, -5, -7, 6, 2, -13, 0, 8, -3, 4, 4, -14, 2}));
    }

    // [[-4, 0, 4], [-4, 1, 3], [-3, -1, 4], [-3, 0, 3], [-3, 1, 2], [-2, -1, 3], [-2, 0, 2], [-1, -1, 2], [-1, 0, 1]]
    // [[-4, 0, 4], [-3, -1, 4], [-2, -1, 3], [-1, -1, 2], [-1, 0, 1]]

}
