package bulls_and_cows;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;

        int[] frequencies = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            frequencies[Integer.parseInt(Character.toString(secret.charAt(i)))]++;
        }

        List<Character> notMatched = new ArrayList<>();
        for (int i = 0; i < secret.length(); i++) {
            char correct = secret.charAt(i);
            char guessChar = guess.charAt(i);
            if (correct == guessChar) {
                bulls++;
                frequencies[Integer.parseInt(Character.toString(secret.charAt(i)))]--;
            } else {
                notMatched.add(guessChar);
            }
        }

        for (Character character : notMatched) {
            int value = Integer.parseInt(Character.toString(character));
            if (frequencies[value] > 0) {
                frequencies[value]--;
                cows++;
            }
        }

        return String.format("%dA%dB", bulls, cows);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getHint("1807", "7810")); // 1A3B
        System.out.println(solution.getHint("1123", "0111")); // 1A1B
    }

}
