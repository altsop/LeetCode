package squares_of_a_sorted_array;

import java.util.Arrays;

public class Solution {

    public static int[] sortedSquares(int[] nums) {
        int[] squared = Arrays.stream(nums).map(x -> x*x).toArray();
        return Arrays.stream(squared).sorted().toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[]{-4, -1, 0, 3, 10})));
    }

}
