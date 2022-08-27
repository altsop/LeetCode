package backspace_string_compare;

public class Solution {

    private static final char BACKSPACE = '#';

    public boolean backspaceCompare(String s, String t) {
        int sCurrentIndex = s.length() - 1;
        int tCurrentIndex = t.length() - 1;

        while (sCurrentIndex >= 0 || tCurrentIndex >= 0) {
            sCurrentIndex = findNextCharIndex(s, sCurrentIndex);
            tCurrentIndex = findNextCharIndex(t, tCurrentIndex);

            if (sCurrentIndex < 0 && tCurrentIndex < 0) {
                return true;
            }

            if (sCurrentIndex < 0 || tCurrentIndex < 0) {
                return false;
            }

            char sCurrentChar = s.charAt(sCurrentIndex);
            char tCurrentChar = t.charAt(tCurrentIndex);

            if (sCurrentChar != tCurrentChar) {
                return false;
            }

            sCurrentIndex--;
            tCurrentIndex--;
        }

        return sCurrentIndex < 0 && tCurrentIndex < 0;
    }

    private int findNextCharIndex(String str, int startIndex) {
        if (startIndex < 0) {
            return startIndex;
        }

        char nextChar = str.charAt(startIndex);
        int elementsToSkip = 0;
        while (nextChar == BACKSPACE) {
            elementsToSkip++;
            startIndex--;
            if (startIndex < 0) {
                break;
            }
            nextChar = str.charAt(startIndex);
        }

        while (elementsToSkip > 0 && startIndex > 0) {
            startIndex--;
            elementsToSkip--;
            if (str.charAt(startIndex) == BACKSPACE) {
                elementsToSkip+=2;
            }
        }
        startIndex -= elementsToSkip;

        if (startIndex >= 0 && str.charAt(startIndex) == BACKSPACE) {
            return findNextCharIndex(str, startIndex);
        }

        return startIndex;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.backspaceCompare("a##c", "#a#c")); // true
        System.out.println(solution.backspaceCompare("1233##555", "1233###2555")); // true
        System.out.println(solution.backspaceCompare("ab##", "c#d#")); // true
        System.out.println(solution.backspaceCompare("a#c", "b")); // false
        System.out.println(solution.backspaceCompare("bxj##tw","bxo#j##tw")); // true
        System.out.println(solution.backspaceCompare("bxj##tw", "bxj###tw")); // false
        System.out.println(solution.backspaceCompare("nzp#o#g", "b#nzp#o#g")); // true
//        123#555
//        1233###2555
    }

}
