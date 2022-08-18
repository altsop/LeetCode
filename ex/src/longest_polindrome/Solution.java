package longest_polindrome;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    public static int longestPalindrome(String s) {
        int longestSize = 0;
        boolean hasElementWithoutPair = false;

        Map<Character, Long> frequencies = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for (Character character : frequencies.keySet()) {
            long frequency = frequencies.get(character);
            if (frequency % 2 == 1) {
                hasElementWithoutPair = true;
            }

            long pairsComposed = frequency / 2;
            longestSize += pairsComposed * 2;
        }

        if (hasElementWithoutPair) {
            longestSize++;
        }

        return longestSize;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));;
    }

}
