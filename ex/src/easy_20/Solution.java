package easy_20;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

public class Solution {

    private static final Map<Character, Character> OPEN_TO_CLOSED = Map.of(
            ')', '(',
            '}', '{',
            ']', '['
    );

    public boolean isValid(String s) {
        Deque<Character> closed = new LinkedList<>();

        for (char c : s.toCharArray()) {
            if (closed.isEmpty()) {
                closed.push(c);
            } else {
                char peek = closed.peek();

                if (OPEN_TO_CLOSED.get(c) != null && OPEN_TO_CLOSED.get(c) == peek) {
                    closed.pop();
                } else {
                    closed.push(c);
                }
            }
        }

        return closed.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("()[]{}"));
        System.out.println(solution.isValid("(]"));
        System.out.println(solution.isValid("(([{}]))"));
        System.out.println(solution.isValid("(){}}{"));
    }
}
