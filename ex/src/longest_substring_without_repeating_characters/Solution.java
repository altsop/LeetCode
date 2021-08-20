package longest_substring_without_repeating_characters;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/
public class Solution {

    public int lengthOfLongestSubstring(String s) {
        int currentCount;
        int maxCount = 0;
        List<Character> uniqueSymbols = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            // start counting the length of a new substring
            currentCount = 1;
            uniqueSymbols.clear();
            uniqueSymbols.add(s.charAt(i));

            // we do not need to count charAt(i) twice
            for (int j = i + 1; j < s.length(); j++) {
                char currentSymbol = s.charAt(j);

                if (s.length() - i < maxCount) {
                    break;
                }

                if (uniqueSymbols.contains(currentSymbol)) {
                     i += uniqueSymbols.indexOf(currentSymbol);
                    break;
                }

                uniqueSymbols.add(currentSymbol);
                currentCount++;
            }

            maxCount = Math.max(currentCount, maxCount);
        }

        return maxCount;
    }

}
