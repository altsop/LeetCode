package decode_string;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {

    public String decodeString(String s) {
        int currentIndex = 0;
        StringBuilder result = new StringBuilder();
        while (currentIndex < s.length()) {
            Queue<Character> queue = composeQueue(s, currentIndex);
            currentIndex += queue.size() + 1;
            result.append(decodeSubstring(queue, false));
        }

        return result.toString();
    }

    private String decodeSubstring(Queue<Character> queue, boolean earlyStop) {
        StringBuilder result = new StringBuilder();
        int multiplier = 1;

        while (!queue.isEmpty()) {
            char element = queue.poll();
            if (element == '[') {
                String repeated = decodeSubstring(queue, true);
                result.append(repeated.repeat(multiplier));
            } else if (element == ']') {
                if (earlyStop) {
                    return result.toString();
                }
            } else if (Character.isDigit(element)) {
                multiplier = parseMultiplier(queue, element);
            } else {
                result.append(element);
            }
        }

        return result.toString();
    }

    private int parseMultiplier(Queue<Character> queue, Character startingElement) {
        StringBuilder result = new StringBuilder();
        result.append(startingElement);
        while (!queue.isEmpty()) {
            char element = queue.peek();
            if (!Character.isDigit(element)) {
                break;
            }

            result.append(element);
            queue.poll();
        }

        return Integer.parseInt(result.toString());
    }

    private Queue<Character> composeQueue(String str, int index) {
        Queue<Character> stack = new LinkedList<>();
        int opened = 0;
        boolean atLeastOneOpened = false;

        while (index < str.length()) {
            char element = str.charAt(index);
            if (element == '[') {
                opened++;
                atLeastOneOpened = true;
            }
            if (element == ']') {
                opened--;
            }

            if (atLeastOneOpened && opened == 0) {
                break;
            }

            stack.add(element);
            index++;
        }

        return stack;
    }

    // 2[2[y]pq4[2[jk]e1[f]]]

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.decodeString("3[a2[c]]")); // accaccacc
        System.out.println(solution.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef")); // ef
        System.out.println(solution.decodeString("10[ef]")); // ef
        System.out.println(solution.decodeString("ef")); // ef
        System.out.println(solution.decodeString("3[a]2[bc]")); // aaabcbc
        System.out.println(solution.decodeString("2[abc]3[cd]ef")); // abcabccdcdcdef
    }

}
