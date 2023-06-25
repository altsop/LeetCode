package year_2022.longest_palindromic_substring;

class Solution {

    public String longestPalindrome(String s) {
        String longestFoundPalindrome = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String substring = s.substring(i, j);

                if (isPalindrome(substring)) {
                    longestFoundPalindrome = getLongest(longestFoundPalindrome, substring);
                }
            }
        }

        return longestFoundPalindrome;
    }

    private boolean isPalindrome(String initial) {
        String reversed = new StringBuilder(initial).reverse().toString();
        return initial.equals(reversed);
    }

    private String getLongest(String s1, String s2) {
        return s1.length() >= s2.length() ? s1 : s2;
    }

}
