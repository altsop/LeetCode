package next_permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// TODO not solved
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.nextPermutation(new int[] {1,2,3,4});
        solution.nextPermutation(new int[] {1,2,3});
        System.out.println(
                solution.permutations
        );
    }

    public List<int[]> permutations;

    /**
     * For example, the next permutation of arr = [1,2,3] is [1,3,2].
     * Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
     * While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
     * <p>
     * <p>
     * [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1]
     * [1,2,3,4] -> [1,2,4,3] -> [1,3,2,4] -> [1,3,4,2]
     * it means that we just move last chosen element to the right
     */
    public void nextPermutation(int[] nums) {
        // in place permutations -> does it mean that we can logically deduce the answer?

        // naive approach would be to find all the permutations and just find the next one
        permutations = new ArrayList<>();

        int[] sorted = Arrays.stream(nums).sorted().toArray();
        permutations.add(sorted);

        int rightIndex = sorted.length -1;
        while (rightIndex >= 0) {
            findAllPermutations(
                    sorted,
                    rightIndex
            );
            rightIndex--;
        }

        System.out.println();
    }


    private void findAllPermutations(int[] arr, int elementIndex) {
        if (elementIndex == arr.length - 1) {
            return;
        }

        int[] newPermutation = Arrays.copyOf(
                arr,
                arr.length
        );
        swap(newPermutation, elementIndex);
        permutations.add(newPermutation);
        findAllPermutations(newPermutation, elementIndex + 1);
    }

    private void swap(int[] arr, int elementIndex) {
        int nextElement = arr[elementIndex + 1];
        int currentElement = arr[elementIndex];

        arr[elementIndex] = nextElement;
        arr[elementIndex + 1] = currentElement;
    }

}
