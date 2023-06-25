package year_2022.pascal_triangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<Integer> getRow(int rowIndex) {
        // base case
        int[] result = new int[]{1};

        // bottom up
        for (int i = 1; i <= rowIndex; i++) {
            int[] row = new int[i + 1];
            row[0] = 1;
            row[row.length - 1] = 1;

            for (int j = 1; j < i; j++) {
                row[j] = result[j] + result[j - 1];
            }

            result = row;
        }

        return Arrays.stream(result).boxed().toList();
    }

    public List<Integer> getRowExpanding(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        result.add(1);

        // bottom up
        for (int i = 1; i <= rowIndex; i++) {

            // we don't change the left most border
            for (int j = result.size() - 2; j >= 0; j--) {
                result.set(j + 1, result.get(j) + result.get(j + 1));
            }

            // right most border is always 1
            result.add(1);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getRow(4));
        System.out.println(solution.getRowExpanding(4));
    }

}
