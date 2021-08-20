package longest_substring_without_repeating_characters;

import java.util.*;

public class Solution2 {

    public int lengthOfLongestSubstring(String s) {
        Map<Integer, State> elementState = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            for (Integer integer : elementState.keySet()) {
                var elementsState = elementState.get(integer);
                if (elementsState.shouldUpdate) {
                    var newElement = s.charAt(i);
                    if (elementsState.elements.contains(newElement)) {
                        elementsState.shouldUpdate = false;
                    } else {
                        elementsState.elements.add(newElement);
                    }
                }
            }
            var newState = new State();
            newState.elements.add(s.charAt(i));
            elementState.put(i, newState);
        }

        return elementState.keySet().stream()
                .map(elementState::get)
                .max(Comparator.comparing((state) -> state.elements.size()))
                .map(state -> state.elements.size()).orElse(0);
    }

    private static class State {

        Set<Character> elements = new HashSet<>();
        boolean shouldUpdate = true;

    }

}
