package year_2022.isomorphic_strings;

import java.util.Set;
import java.util.stream.Collectors;

class Solution2 {

    public boolean isIsomorphic(String s, String t) {
        Set<Character> sChars = composeCharacterSet(s);
        Set<Character> tChars = composeCharacterSet(t);

        return sChars.containsAll(tChars);
    }

    private Set<Character> composeCharacterSet(String str) {
        return str.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
    }
}
