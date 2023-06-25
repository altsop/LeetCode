package year_2022.data_structures.pascal_triangle;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows > 0) {
            result.add(List.of(1));
        }

        for (int i = 1; i < numRows; i++) {
            List<Integer> row = composeRow(result.get(result.size() - 1));
            result.add(row);
        }

        return result;
    }

    private List<Integer> composeRow(List<Integer> previous) {
        List<Integer> row = new ArrayList<>();
        // left side
        row.add(1);

        for (int i = 0; i < previous.size() - 1; i++) {
            row.add(previous.get(i) + previous.get(i + 1));
        }

        // right side
        row.add(1);

        return row;
    }

    public static void main(String[] args) {
        var a = new Solution().generate(4);
    }

}
