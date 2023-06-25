package year_2022.generate_parentheses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/generate-parentheses/
class Solution {

    private int n = 0;
    private List<String> result = new ArrayList<>();
    private Set<String> combinations = new HashSet<>();

    // Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
    public List<String> generateParenthesis(int n) {
        this.n = n;
        this.result = new ArrayList<>();
        this.combinations = new HashSet<>();

        process(Set.of("()"));

        return result;
    }

    private void process(Set<String> correctPairs) {
        for (String combination : correctPairs) {
            if (combination.length() / 2 == n) {
                if (!combinations.contains(combination)) {
                    combinations.add(combination);
                    result.add(combination);
                }
            } else {
                Set<String> permutations = calculatePermutations(combination);
                process(permutations);
            }
        }
    }

    private Set<String> calculatePermutations(String s) {
        String pair = "()";
        Set<String> permutations = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            StringBuilder permutation = new StringBuilder(s);
            permutation.insert(i, pair);
            permutations.add(permutation.toString());
        }

        permutations.add(s + "()");

        return permutations;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateParenthesis(1));
        System.out.println(solution.generateParenthesis(2));
        System.out.println(solution.generateParenthesis(3));
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    @Override
    public String toString() {
        return "Solution{" +
                "n=" + n +
                ", result=" + result +
                ", combinations=" + combinations +
                '}';
    }
}