package year_2022.reverse_integer;

public class Solution2 {

    private static final String MAX_INT = String.valueOf(Integer.MAX_VALUE);
    private static final String MIN_INT = String.valueOf(Integer.MIN_VALUE);

    public int reverse(int x) {
        String xStringReversed = composeRevertedString(x);
        String xStringReversedWithoutLeadingZeros = removeLeadingZeros(xStringReversed);
        if (notLargerThanMaxInt(xStringReversedWithoutLeadingZeros) && notSmallerThanMinInt(xStringReversedWithoutLeadingZeros)) {
            return Integer.parseInt(xStringReversedWithoutLeadingZeros);
        }
        return 0;
    }

    private String composeRevertedString(int x) {
        String reversed = new StringBuilder(String.valueOf(x)).reverse().toString();
        if (x < 0) {
            return "-" + reversed.substring(0, reversed.length() - 1);
        }
        return reversed;
    }

    private String removeLeadingZeros(String x) {
        boolean isLeadingZero = true;
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : x.toCharArray()) {
            if (c == '-') {
                stringBuilder.append(c);
            } else if (c == '0') {
                if (!isLeadingZero) {
                    stringBuilder.append(c);
                }
            } else {
                isLeadingZero = false;
                stringBuilder.append(c);
            }
        }
        return stringBuilder.length() > 0 ? stringBuilder.toString() : "0";
    }

    private boolean notSmallerThanMinInt(String x) {
        if (x.charAt(0) != '-') {
            return true;
        }

        if (x.length() < MIN_INT.length()) {
            return true;
        } else if (x.length() > MIN_INT.length()) {
            return false;
        }

        for (int i = 1; i < x.length(); i++) {
            if (MIN_INT.charAt(i) > x.charAt(i)) {
                return true;
            } else if (MIN_INT.charAt(i) < x.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    private boolean notLargerThanMaxInt(String x) {
        if (x.charAt(0) == '-') {
            return true;
        }

        if (x.length() < MAX_INT.length()) {
            return true;
        } else if (x.length() > MAX_INT.length()) {
            return false;
        }

        for (int i = 0; i < x.length(); i++) {
            if (MAX_INT.charAt(i) > x.charAt(i)) {
                return true;
            } else if (MAX_INT.charAt(i) < x.charAt(i)) {
                return false;
            }
        }

        return true;
    }

}
