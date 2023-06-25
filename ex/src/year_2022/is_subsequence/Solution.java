package year_2022.is_subsequence;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static boolean isSubsequence(String subsequenceCandidate, String t) {
        if (subsequenceCandidate.length() > t.length()) {
            return false;
        }

        Queue<Character> queue = new LinkedList<>();
        subsequenceCandidate.chars().mapToObj(c -> (char) c).forEach(queue::add);

        for (char character : t.toCharArray()) {
            if (queue.isEmpty()) {
                break;
            }

            char toBeChecked = queue.peek();
            if (toBeChecked == character) {
                queue.poll();
            }
        }

        return queue.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));
        System.out.println(isSubsequence("aabc", "ahbgdc"));
    }

}
