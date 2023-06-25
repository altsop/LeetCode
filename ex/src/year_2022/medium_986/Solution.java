package year_2022.medium_986;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<List<Integer>> result = new ArrayList<>();

        int first = 0;
        int second = 0;
        while (first < firstList.length && second < secondList.length) {
            int firstStart = firstList[first][0];
            int secondStart = secondList[second][0];

            int firstEnd = firstList[first][1];
            int secondEnd = secondList[second][1];

            if (firstStart > secondEnd) {
                second++;
                continue;
            }

            if (secondStart > firstEnd) {
                first++;
                continue;
            }

            if (firstStart < secondStart) {
                firstStart += secondStart - firstStart;
            } else if (secondStart < firstStart) {
                secondStart += firstStart - secondStart;
            }

            if (firstStart == secondStart) {
                int start = firstStart;
                while (firstStart <= firstEnd && secondStart <= secondEnd) {
                    firstStart++;
                    secondStart++;
                }
                int end = firstStart - 1;
                result.add(List.of(start, end));
            }

            if (firstStart < secondStart) {
                first++;
            } else {
                if (firstEnd < secondEnd) {
                    first++;
                } else {
                    second++;
                }
            }
        }

        int[][] arrayResult = new int[result.size()][];
        for (int j = 0; j < result.size(); j++) {
            arrayResult[j] = new int[]{result.get(j).get(0), result.get(j).get(1)};
        }

        return arrayResult;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.intervalIntersection(
                new int[][]{new int[]{0, 2}, new int[]{5, 10}, new int[]{13, 23}, new int[]{24, 25}},
                new int[][]{new int[]{1,5}, new int[]{8,12}, new int[]{15, 24}, new int[]{25, 26}}
        ));
    }

}