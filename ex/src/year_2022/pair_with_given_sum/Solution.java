package year_2022.pair_with_given_sum;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    static boolean findSumOfTwo(int[] array, int destinationSum) {
        Set<Integer> remainders = new HashSet<>();

        for (Integer element : array) {
            int remainder = destinationSum - element;
            if (remainders.contains(remainder)) {
                return true;
            }
            remainders.add(remainder);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] v = new int[]{ 5, 7, 1, 2, 8, 4, 3 };
        int[] test = new int[]{ 3, 20, 1, 2, 7 };

        for (int i = 0; i < test.length; i++) {
            boolean output = findSumOfTwo(v, test[i]);
            System.out.println("findSumOfTwo(v, " + test[i] + ") = " + (output ? "true" : "false"));
        }

    }
}
