package longest_palindrome_concatenating_tow_letter_words;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    public int longestPalindrome(String[] words) {
        Map<String, Long> frequency = Arrays.stream(words)
                .collect(Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        )
                );

        int elementSize = words[0].length();
        boolean duplicatedCharacterCombinationUsed = false;
        int palindromeSize = 0;

        for (String key : frequency.keySet()) {
            long value = frequency.get(key);
            boolean isDuplicateCombination = isDuplicateCharacterCombination(key);

            if (isDuplicateCombination) {
                if (!duplicatedCharacterCombinationUsed) {
                    if (value % 2 == 1) {
                        duplicatedCharacterCombinationUsed = true;
                        palindromeSize += elementSize;
                    }
                }
                palindromeSize += (value / 2) * elementSize * 2;
            } else {
                String reversed = composeReversed(key);
                if (frequency.containsKey(reversed)) {
                    long reversedFrequency = frequency.get(reversed);
                    long usedForPalindrome = Math.min(value, reversedFrequency);
                    frequency.put(reversed, reversedFrequency - usedForPalindrome);
                    frequency.put(key, value - usedForPalindrome);
                    palindromeSize += usedForPalindrome * elementSize * 2;
                }
            }
        }

        return palindromeSize;
    }

    private boolean isDuplicateCharacterCombination(String str) {
        return str.chars().mapToObj(c -> (char) c).collect(Collectors.toSet()).size() == 1;
    }

    private String composeReversed(String str) {
        char[] reversed = new char[str.length()];
        int left, right = str.length() - 1;
        for (left = 0; left < right; left++, right--) {
            char leftChar = str.charAt(left);
            reversed[left] = str.charAt(right);
            reversed[right] = leftChar;
        }

        return String.valueOf(reversed);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome(new String[]{"dd","aa","bb","dd","aa","dd","bb","dd","aa","cc","bb","cc","dd","cc"})); // 22
        System.out.println(solution.longestPalindrome(new String[]{"ab", "ty", "yt", "lc", "cl", "ab"})); // 8
        System.out.println(solution.longestPalindrome(new String[]{"cc","ll","xx"})); // 2
        System.out.println(solution.longestPalindrome(new String[]{"lc","cl","gg"})); // 6
    }

}
