package year_2022.longest_substring_without_repeating_characters;

import java.util.Arrays;

public class Solution3 {

    static final int NO_OF_CHARS = 256;

    public int lengthOfLongestSubstring(String str) {
        int res = 0; // result

        // last index of all characters is initialized
        // as -1
        int[] lastIndex = new int[NO_OF_CHARS];
        Arrays.fill(lastIndex, -1);

        // Initialize start of current window
        int i = 0;

        // Move end of current window
        for (int j = 0; j < str.length(); j++) {

            // Find the last index of str[j]
            // Update i (starting index of current window)
            // as maximum of current value of i and last
            // index plus 1
            i = Math.max(i, lastIndex[str.charAt(j)] + 1);

            // Update result if we get a larger window
            res = Math.max(res, j - i + 1);

            // Update last index of j.
            lastIndex[str.charAt(j)] = j;
        }
        return res;
    }


}
