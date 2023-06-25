package year_2022.medium_add_two_numbers;

public class Solution3 {

    public static char[] reverseWords(char [] input) {
        for(int i=0; i < input.length; i++) {
            int wordLength = lengthOfNextWord(input, i);

            for(int j=0; j < wordLength / 2; j++) {
                int indexA = i + j;
                int indexB = i + wordLength - 1 - j;
                changeLetters(indexA, indexB, input);
            }

            i += wordLength;
        }
        return input;
    }

    private static int lengthOfNextWord(char [] arr, int startingIndex) {
        int count = 0;
        for(int i = startingIndex; i < arr.length; i++) {
            if(arr[i] == ' ') {
                break;
            }
            count++;
        }
        return count;
    }

    private static void changeLetters(int indexA, int indexB, char [] arr) {
        char temp = arr[indexB];
        arr[indexB] = arr[indexA];
        arr[indexA] = temp;
    }


}
