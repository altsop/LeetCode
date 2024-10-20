package year_2024.add_binary_67;

import java.util.Arrays;

class Solution {

    public String addBinary(
            String a,
            String b
    ) {
        String longest = a.length() >= b.length() ? a : b;
        String shortest = a.length() < b.length() ? a : b;
        String longShortest = makeShortestSameSize(longest, shortest);

        StringBuilder result = new StringBuilder();
        int buffer = 0;
        for (int i = longest.length() - 1; i > -1; i--) {
            final var c1 = longest.charAt(i);
            final var c2 = longShortest.charAt(i);

            int i1 = Integer.parseInt(String.valueOf(c1));
            int i2 = Integer.parseInt(String.valueOf(c2));

            int sum = i1 + i2 + buffer;

            if (sum < 2) {
                result.insert(0, sum);
                buffer = 0;
            } else {
                result.insert(0, sum - 2);
                buffer = 1;
            }
        }

        if (buffer > 0) {
            result.insert(0, buffer);
        }

        return result.toString();
    }

    private String makeShortestSameSize(String longest, String shortest) {
        int sizeDifference = longest.length() - shortest.length();

        final var zeros = new char[sizeDifference];
        Arrays.fill(zeros, '0');
        return new String(zeros) + shortest;
    }

    public static void main(String[] args) {
        final var solution = new Solution();
        final var s1 = solution.addBinary("11", "11");
        System.out.println(s1);
    }

}
