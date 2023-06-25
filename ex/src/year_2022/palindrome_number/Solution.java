package year_2022.palindrome_number;

public class Solution {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int original = x;
        int reversed = 0;
        // 101
        while(x > 0) {
            int remainder = x % 10; // 1
            x = x / 10; // 0
            reversed = reversed * 10 + remainder; // 101
        }

        return reversed == original;
    }

}
