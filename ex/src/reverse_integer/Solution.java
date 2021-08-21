package reverse_integer;

import java.math.BigInteger;

class Solution {

    public int reverse(int x) {
        String xStringReversed = composeRevertedString(x);
        BigInteger bigInteger = new BigInteger(xStringReversed);
        if (bigInteger.compareTo(new BigInteger(String.valueOf(Integer.MAX_VALUE))) > 0) {
            return  0;
        }
        return bigInteger.intValue();
    }

    private String composeRevertedString(int x) {
        String reversed = new StringBuilder(String.valueOf(x)).reverse().toString();
        if (x < 0) {
            return "-" + reversed.substring(0, reversed.length() - 1);
        }
        return reversed;
    }

}
