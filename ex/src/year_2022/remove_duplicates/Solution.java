package year_2022.remove_duplicates;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public int removeDuplicates(int[] nums) {
        // remove the duplicates in-place -> do not create a new int array
        // how to understand that element at index n is duplicate
        // 1. Set = elementsSeen
        //  nums[n] = x
        //  we check weather elementsSeen.contains(x) -> true -> it is a duplicate
        //  nums[n] < nums[n - 1]
        int duplicateCounter = 0;
        int previous = Integer.MIN_VALUE;
        int current;

        Queue<Integer> freeIndexes = new LinkedList<>();

        // [0,1,1,1,2,2,3,3,4]

        // [0, 1,1,1,2,2,3,3,4]
        // [0, 1, 1,1,2,2,3,3,4]
        // [0, 1, 1, 1,2,2,3,3,4] = 2
        // [0, 1, 1, 1, 2,2,3,3,4]
        // [0, 1, 2, 1, 2, 2,3,3,4]
        // [0, 1, 2, 1, 2, 2,3,3,4]
        for (int i = 0; i < nums.length; i++) {
            current = nums[i];

            if (i != 0) {
                if (isDuplicate(previous, current)) {
                    duplicateCounter++;
                    freeIndexes.add(i);
                } else if (!freeIndexes.isEmpty()) {
                    freeIndexes.add(i);
                    Integer freeIndex = freeIndexes.poll();
                    if (freeIndex == null) {
                        throw new RuntimeException("null was polled from the queue");
                    } else  {
                        nums[freeIndex] = nums[i];
                    }
                }
            }

            previous = nums[i];
        }

        return nums.length - duplicateCounter;
    }

    private boolean isDuplicate(int previous, int current) {
        return previous == current;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates(new int[]{1, 2, 2})); // 2
        System.out.println(solution.removeDuplicates(new int[]{1, 2, 2, 3})); // 3
    }

}
