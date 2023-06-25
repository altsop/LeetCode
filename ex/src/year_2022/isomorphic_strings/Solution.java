package year_2022.isomorphic_strings;

import java.util.*;

class Solution {

    public static boolean isIsomorphic(String input, String isomorphicCandidate) {
        if (input.length() != isomorphicCandidate.length()) {
            return false;
        }

        Map<Character, Character> oldToNew = new HashMap<>();
        Set<Character> usedNewValues = new HashSet<>();

        for (int i = 0; i < isomorphicCandidate.length(); i++) {
            char oldChar = isomorphicCandidate.charAt(i);
            char newChar = input.charAt(i);

            if (oldToNew.containsKey(oldChar)) {
                if (newChar != oldToNew.get(oldChar)) {
                    return false;
                }
            } else {
                if (usedNewValues.contains(newChar)) {
                    return false;
                }

                oldToNew.put(oldChar, newChar);
                usedNewValues.add(newChar);
            }
        }

        return true;
    }

    public static void main(String[] args) {
//        System.out.println(isIsomorphic("paper", "title"));
        System.out.println(isIsomorphic("badc", "baba"));
        System.out.println(isIsomorphic("foo", "bar"));
    }

}
