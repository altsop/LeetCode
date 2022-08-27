package decode_string;

import java.util.Stack;

public class Solution {

    public String decodeString(String s) {
        int currentIndex = 0;
        StringBuilder result = new StringBuilder();
        while (currentIndex < s.length()) {
            Stack<Character> stack = composeStack(s, currentIndex);
            currentIndex += stack.size() + 1;
            result.append(composeElement(stack));
        }

        return result.toString();
    }

    private String composeElement(Stack<Character> stack) {
        boolean isMultiplierNext = false;
        boolean isRepeatedNext = false;

        StringBuilder repeated = new StringBuilder();
        StringBuilder multiplier = new StringBuilder();

        while (!stack.isEmpty()) {
            char currentElement = stack.pop();
            if (isMultiplierNext) {
                while (Character.isDigit(currentElement)) {
                    multiplier.insert(0, currentElement);

                    if (stack.isEmpty()) {
                        break;
                    }
                    currentElement = stack.pop();
                }
                repeated = new StringBuilder(repeated.toString().repeat(Integer.parseInt(multiplier.toString())));
                isMultiplierNext = false;
                multiplier = new StringBuilder();

                if (stack.isEmpty() && Character.isDigit(currentElement)) {
                    break;
                }
            }

            if (currentElement == ']') {
                isRepeatedNext = true;
            } else if (currentElement == '[') {
                isMultiplierNext = true;
                isRepeatedNext = false;
            } else if (isRepeatedNext) {
                repeated.append(currentElement);
            } else {
                repeated.insert(0, currentElement);
            }

        }

        return repeated.toString();
    }

    private Stack<Character> composeStack(String str, int index) {
        Stack<Character> stack = new Stack<>();
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

            stack.push(element);
            index++;
        }

        return stack;
    }

    // 2[2[y]pq4[2[jk]e1[f]]]

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef")); // ef
        System.out.println(solution.decodeString("10[ef]")); // ef
        System.out.println(solution.decodeString("ef")); // ef
        System.out.println(solution.decodeString("3[a2[c]]")); // accaccacc
        System.out.println(solution.decodeString("3[a]2[bc]")); // aaabcbc
        System.out.println(solution.decodeString("2[abc]3[cd]ef")); // abcabccdcdcdef
    }

}
