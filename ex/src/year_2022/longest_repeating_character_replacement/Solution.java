package year_2022.longest_repeating_character_replacement;

// remained unsolved
public class Solution {

    public int characterReplacement(String s, int k) {
        int longest = 1;

        for (int i = 0; i <= s.length() - longest; i++) {
            int localK = k;

            int localLongest = 1;
            int current = s.charAt(i);

            int back = i - 1;
            while (back >= 0) {
                if (s.charAt(back) != current) {
                    break;
                }
                localLongest++;
                back--;
            }

            for (int j = i + 1; j <= s.length() - longest; j++) {
                if (s.charAt(j) != current) {
                    localK--;
                }

                if (localK >= 0) {
                    localLongest++;
                }

                if (localK == 0) {
                    int forward = j + 1;
                    while (forward < s.length()) {
                        if (s.charAt(forward) != current) {
                            break;
                        }
                        localLongest++;
                        forward++;
                    }
                    break;
                }
            }

            longest = Math.max(localLongest, longest);
        }

        return longest;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.characterReplacement("ABAB", 2)); // 4
//        System.out.println(solution.characterReplacement("AABABBA", 2)); // 5
//        System.out.println(solution.characterReplacement("AABABBA", 1)); // 4
//        System.out.println(solution.characterReplacement("ABAA", 0)); // 1
        System.out.println(solution.characterReplacement("ABBB", 2)); // 4
    }

}
