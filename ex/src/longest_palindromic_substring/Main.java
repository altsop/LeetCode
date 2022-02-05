package longest_palindromic_substring;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.longestPalindrome("babad")); // bab
//        System.out.println(solution.longestPalindrome("cbbd")); // bb
//        System.out.println(solution.longestPalindrome("a")); // a
//        System.out.println(solution.longestPalindrome("ac")); // a
//        System.out.println(solution.longestPalindrome("")); //

//        Solution2 solution2 = new Solution2();
//        System.out.println(solution2.longestPalindrome("babad")); // bab
//        System.out.println(solution2.longestPalindrome("cbbd")); // bb
//        System.out.println(solution2.longestPalindrome("a")); // a
//        System.out.println(solution2.longestPalindrome("ac")); // a
//        System.out.println(solution2.longestPalindrome("")); //

        System.out.println(new Solution3().longestPalindrome("babad")); // bab
        System.out.println(new Solution3().longestPalindrome("cbbd")); // bb
        System.out.println(new Solution3().longestPalindrome("swap_pairs")); // a
        System.out.println(new Solution3().longestPalindrome("ac")); // a
        System.out.println(new Solution3().longestPalindrome("")); //
    }

}
