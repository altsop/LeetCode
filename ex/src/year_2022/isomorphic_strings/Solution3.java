package year_2022.isomorphic_strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class Solution3 {

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mapping = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            char fromS = s.charAt(i);
            char fromT = t.charAt(i);

            if (mapping.containsKey(fromT)) {
                if (fromS != mapping.get(fromT)) {
                    return false;
                }
            }

            mapping.put(fromT, fromS);
        }

        return true;
    }

    private Set<Character> composeCharacterSet(String str) {
        return str.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
    }
}
