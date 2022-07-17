package three_sum;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    private static class Triplet {

        int a;
        int b;
        int c;

        private final Set<Integer> uniqueElements = new HashSet<>();

        public Triplet(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;

            uniqueElements.add(a);
            uniqueElements.add(b);
            uniqueElements.add(c);
        }

        @Override
        public boolean equals(Object obj) {
            Triplet other = (Triplet) obj;
            return this.uniqueElements.equals(other.uniqueElements);
        }

        @Override
        public int hashCode() {
            return a + b + c;
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        // T = a
        // a + b + c = 0 => b + c = -T

        //i != j, i != k, and j != k

        // populate hashmap (O(n))
        Map<Integer, List<Integer>> valueToIndex = createMapOfValueToIndexes(nums);
        Set<Triplet> result = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    int sum = nums[i] + nums[j];
                    if (valueToIndex.containsKey(sum)) {
                        List<Integer> possibleIndexes = valueToIndex.get(sum);
                        for (Integer k : possibleIndexes) {
                            if (k != i && k != j) {
                                result.add(new Triplet(nums[i], nums[j], nums[k]));
                            }
                        }
                    }
                }
            }
        }

        return result.stream().map(triplet -> List.of(triplet.a, triplet.b, triplet.c)).collect(Collectors.toList());
    }

    private Map<Integer, List<Integer>> createMapOfValueToIndexes(int[] nums) {
        Map<Integer, List<Integer>> valueToIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int key = (-1) * nums[i];
            if (valueToIndex.containsKey(key)) {
                valueToIndex.get(key).add(i);
            } else {
                List<Integer> indexes = new ArrayList<>();
                indexes.add(i);
                valueToIndex.put(key, indexes);
            }
        }

        return valueToIndex;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

}
