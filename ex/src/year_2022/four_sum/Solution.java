package year_2022.four_sum;

import java.util.*;

public class Solution {

    // O(n3) - time complexity
    // O(1) - memory complexity
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Set<CombinationOfFour> combinations = new HashSet<>();
        Arrays.sort(nums);

        // O(n)
        for (int i = 0; i < nums.length; i++) {
            // O(n)
            for (int j = i + 1; j < nums.length; j++) {
                int k = j + 1;
                int m = nums.length - 1;
                // O(n)
                while (k < m) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[m];
                    int diff = Math.abs(sum - target);
                    if (diff == 0) {
                        CombinationOfFour combinationOfFour = new CombinationOfFour(nums[i], nums[j], nums[k], nums[m]);
                        if (!combinations.contains(combinationOfFour)) {
                            combinations.add(combinationOfFour);
                            result.add(List.of(nums[i], nums[j], nums[k], nums[m]));
                        }
                    }

                    if (sum > target) {
                        m--;
                    } else {
                        k++;
                    }
                }
            }
        }

        return result;
    }

    private static class CombinationOfFour {

        int a;
        int b;
        int c;
        int d;

        public CombinationOfFour(int a, int b, int c, int d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            CombinationOfFour that = (CombinationOfFour) o;

            if (a != that.a) return false;
            if (b != that.b) return false;
            if (c != that.c) return false;
            return d == that.d;
        }

        @Override
        public int hashCode() {
            int result = a;
            result = 31 * result + b;
            result = 31 * result + c;
            result = 31 * result + d;
            return result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0)); // [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
        System.out.println(solution.fourSum(new int[]{2, 2, 2, 2, 2}, 8)); // [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
    }

}
