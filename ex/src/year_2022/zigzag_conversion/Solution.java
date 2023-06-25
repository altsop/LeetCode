package year_2022.zigzag_conversion;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/zigzag-conversion/submissions/
public class Solution {

    public String convert(String s, int numRows) {
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }

        int alreadyInsertedAmount = 0;

        while (alreadyInsertedAmount != s.length()) {
            alreadyInsertedAmount += upToDownInsert(
                    numRows,
                    list,
                    s,
                    alreadyInsertedAmount
            );
            int insertedAmount = diagonalInsert(
                    numRows,
                    list,
                    s,
                    alreadyInsertedAmount
            );
            alreadyInsertedAmount += insertedAmount;
        }

        return convertArrayToString(list);
    }

    private int upToDownInsert(
            int numRows,
            List<StringBuilder> list,
            String source,
            int alreadyInsertedAmount
    ) {
        int newlyInsertedAmount = 0;

        while (numRows > newlyInsertedAmount) {
            int currentIndex = alreadyInsertedAmount + newlyInsertedAmount;
            if (source.length() <= currentIndex) {
                break;
            }

            char current = source.charAt(currentIndex);
            list.get(newlyInsertedAmount).append(current);

            newlyInsertedAmount++;
        }

        return newlyInsertedAmount;
    }

    private int diagonalInsert(
            int numRows,
            List<StringBuilder> list,
            String source,
            int alreadyInsertedAmount
    ) {
        int newlyInsertedAmount = 0;

        while (numRows - 2 > newlyInsertedAmount) {
            int currentIndex = alreadyInsertedAmount + newlyInsertedAmount;
            if (source.length() <= currentIndex) {
                break;
            }

            char current = source.charAt(currentIndex);
            int rowNumber = numRows - 2 - newlyInsertedAmount;
            list.get(rowNumber).append(current);

            newlyInsertedAmount++;
        }

        return newlyInsertedAmount;
    }

    private String convertArrayToString(List<StringBuilder> list) {
        StringBuilder result = new StringBuilder();
        for (StringBuilder stringBuilder : list) {
            result.append(stringBuilder);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String a = solution.convert("PAYPALISHIRING", 3);
        System.out.println(a);
    }

}
