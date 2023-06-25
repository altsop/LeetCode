package year_2022.plus_one;

import java.util.Arrays;

public class Solution {

    // https://leetcode.com/problems/plus-one/
    public int[] plusOne(int[] digits) {
        int cursor = digits.length - 1;

        while (cursor >= 0) {
            if (digits[cursor] < 9) {
                digits[cursor]++;
                return digits;
            }

            digits[cursor] = 0;
            cursor--;
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(solution.plusOne(new int[]{9})));
        System.out.println(Arrays.toString(solution.plusOne(new int[]{9, 9})));
    }

}
