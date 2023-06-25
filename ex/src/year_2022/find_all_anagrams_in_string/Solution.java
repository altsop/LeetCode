package year_2022.find_all_anagrams_in_string;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (p.length() > s.length()) {
            return result;
        }

        int[] pFrequencies = calculateFrequencies(p);

        for (int start = 0; start <= s.length() - p.length(); start++) {
            int end = start + p.length();
            String window = s.substring(start, end);
            if (isAnagram(window, pFrequencies)) {
                result.add(start);
            }
        }

        return result;
    }

    private int[] calculateFrequencies(String str) {
        int[] frequencies = new int[26];
        str.chars()
                .mapToObj(c -> (char) c)
                .forEach(c -> frequencies[c - 'a']++);

        return frequencies;
    }

    private boolean isAnagram(String anagramCandidate, int[] frequencies) {
        int[] candidateFrequencies = new int[26];
        for (char c : anagramCandidate.toCharArray()) {
            int index = c - 'a';
            if (frequencies[index] == 0) {
                return false;
            }
            candidateFrequencies[index]++;
        }

        for (int i = 0; i < frequencies.length; i++) {
            if (candidateFrequencies[i] != frequencies[i]) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findAnagrams("cbaebabacd", "abc"));
        System.out.println(solution.findAnagrams("abab", "ab"));
    }

}
