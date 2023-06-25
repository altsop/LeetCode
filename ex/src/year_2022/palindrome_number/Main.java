package year_2022.palindrome_number;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(101));
        System.out.println(solution.isPalindrome(-101));
        System.out.println(solution.isPalindrome(1001));
        System.out.println(solution.isPalindrome(Integer.MAX_VALUE));
    }

}
