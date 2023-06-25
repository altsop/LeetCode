package year_2022.longest_common_prefix;

import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public String longestCommonPrefix(String[] strs) {
        List<Character> chars = strs[0].chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        int bestMatchIndex = chars.size() - 1;

        for (int i = 1; i < strs.length; i++) {
            String currentStr = strs[i];
            int j;
            for (j = 0; j < currentStr.length(); j++) {
                if (bestMatchIndex == -1) {
                    return "";
                } else if (bestMatchIndex < j) {
                    break;
                }

                char currentChar = currentStr.charAt(j);
                if (currentChar != chars.get(j)) {
                    bestMatchIndex = j - 1;
                    break;
                }
            }

            if (j == currentStr.length()) {
                bestMatchIndex = j - 1;
            }
        }

        return strs[0].substring(0, bestMatchIndex + 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"})); //"fl"
        System.out.println(solution.longestCommonPrefix(new String[]{"dog", "racecar", "car"})); //"
    }

}
