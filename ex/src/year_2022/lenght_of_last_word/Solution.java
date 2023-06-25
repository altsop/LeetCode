package year_2022.lenght_of_last_word;

import java.util.Stack;

//https://leetcode.com/problems/length-of-last-word/
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLastWord("   fly me   to   the moon  "));
    }

    public int lengthOfLastWord(String s) {
        int startingIndex = findStartingIndex(s);
        return readString(
                s,
                startingIndex
        ).length();
    }

    private int findStartingIndex(String s) {
        int cursor = s.length() - 1;

        while (cursor >= 0 && s.charAt(cursor) == ' ') {
            cursor--;
        }

        return cursor;
    }

    private String readString(String s, int cursor) {
        Stack<Character> stack = new Stack<>();
        while (cursor >= 0 && s.charAt(cursor) != ' ') {
            stack.add(s.charAt(cursor));
            cursor--;
        }

        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }

        return builder.toString();
    }

}
