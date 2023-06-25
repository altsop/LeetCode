package year_2022.find_the_index_of_the_first_occurrence_in_a_string;

public class Solution {

    private static final int MATCH_FLAG = -1;

    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            String substr = haystack.substring(i, i + needle.length());
            int matchedChars = calculateAmountOfMatchedChars(substr, needle);
            if (matchedChars == MATCH_FLAG) {
                return i;
            }
        }

        return -1;
    }

    private int calculateAmountOfMatchedChars(String sample, String target) {
        for (int i = 0; i < sample.length(); i++) {
            char sampleChar = sample.charAt(i);
            char targetChar = target.charAt(i);
            if (sampleChar != targetChar) {
                return i;
            }
        }

        return MATCH_FLAG;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.strStr("sadbutsad", "sad"));
//        System.out.println(solution.strStr("leetcode", "leeto"));
        System.out.println(solution.strStr("mississippi", "issip"));
    }

}
