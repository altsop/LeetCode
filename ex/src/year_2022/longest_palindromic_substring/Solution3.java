package year_2022.longest_palindromic_substring;

public class Solution3 {

    private int startIndex = 0;
    private int longestPalindromeLength;

    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i + 1); //assume even length.
        }
        return s.substring(startIndex, startIndex + longestPalindromeLength);
    }

    private void extendPalindrome(String s, int j, int k) {
        // we expand in both directions
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (longestPalindromeLength < k - j - 1) {
            startIndex = j + 1;
            longestPalindromeLength = k - j - 1;
        }
    }

}