package year_2022.longest_palindromic_substring;

public class Solution2 {

    public String longestPalindrome(String initial) {
        String longestFoundPalindrome = "";
        String reversed = new StringBuilder(initial).reverse().toString();

        for (int i = 0; i < initial.length(); i++) {
            for (int j = i + 1; j < initial.length() + 1; j++) {
                String substring = initial.substring(i, j);
                if (reversed.contains(substring)) {
                    if (isPalindrome(substring)) {
                        longestFoundPalindrome = getLongest(longestFoundPalindrome, substring);
                    }
                } else {
                    break;
                }
            }
        }

        return longestFoundPalindrome;
    }

    private String getLongest(String s1, String s2) {
        return s1.length() >= s2.length() ? s1 : s2;
    }

    private boolean isPalindrome(String initial) {
        String reversed = new StringBuilder(initial).reverse().toString();
        return initial.equals(reversed);
    }

}
