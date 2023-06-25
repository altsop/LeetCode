package year_2022.letter_combinations_of_a_phone_number;

import java.util.*;

public class Solution {

    private final static Map<Character, List<Character>> digitToCharacters = new HashMap<>();

    static {
        digitToCharacters.put('2', List.of('a', 'b', 'c'));
        digitToCharacters.put('3', List.of('d', 'e', 'f'));
        digitToCharacters.put('4', List.of('g', 'h', 'i'));
        digitToCharacters.put('5', List.of('j', 'k', 'l'));
        digitToCharacters.put('6', List.of('m', 'n', 'o'));
        digitToCharacters.put('7', List.of('p', 'q', 'r', 's'));
        digitToCharacters.put('8', List.of('t', 'u', 'v'));
        digitToCharacters.put('9', List.of('w', 'x', 'y', 'z'));
    }

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return Collections.emptyList();
        }

        // 4. compose combination
        Set<String> combinations = new HashSet<>();
        findCombinations(combinations, new StringBuilder(), digits, 0);

        return List.copyOf(combinations);
    }

    private void findCombinations(Set<String> combinations, StringBuilder combination, String digits, int indexI) {
        if (digits.length() == combination.length()) {
            combinations.add(combination.toString());
            return;
        }

        for (int i = indexI; i < digits.length(); i++) {
            Character digit = digits.charAt(i);
            List<Character> characters = digitToCharacters.get(digit);

            for (Character character : characters) {
                StringBuilder newCombination = new StringBuilder(combination);
                newCombination.append(character);

                findCombinations(
                        combinations,
                        newCombination,
                        digits,
                        i + 1
                );
            }

        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        var result1 = solution.letterCombinations("23");
        System.out.println(result1);
    }

}
