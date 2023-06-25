package year_2022.integer_to_roman;

public class Solution {

    public String intToRoman(int num) {
        return String.valueOf(composeThousands(num)) +
                composeHundreds(num) +
                composeDecades(num) +
                composeDigits(num);
    }

    private StringBuilder composeThousands(int num) {
        StringBuilder thousands = new StringBuilder();
        int thousandCount = num / 1000;
        thousands.append("M".repeat(Math.max(0, thousandCount)));

        return thousands;
    }

    private StringBuilder composeHundreds(int num) {
        StringBuilder hundreds = new StringBuilder();
        int hundredCount = (num % 1000) / 100;
        if (hundredCount == 9) {
            hundreds.append("CM");
        } else if (hundredCount == 4) {
            hundreds.append("CD");
        } else if (hundredCount < 4) {
            hundreds.append("C".repeat(Math.max(0, hundredCount)));
        }  else {
            hundreds.append("D");
            hundreds.append("C".repeat(Math.max(0, hundredCount - 5)));
        }

        return hundreds;
    }

    private StringBuilder composeDecades(int nums) {
        StringBuilder decades = new StringBuilder();
        int decadeCount = (nums % 100) / 10 ;

        if (decadeCount == 9) {
            decades.append("XC");
        } else if (decadeCount == 4) {
            decades.append("XL");
        } else if (decadeCount < 4) {
            decades.append("X".repeat(Math.max(0, decadeCount)));
        }  else {
            decades.append("L");
            decades.append("X".repeat(Math.max(0, decadeCount - 5)));
        }

        return decades;
    }

    private StringBuilder composeDigits(int nums) {
        StringBuilder digits = new StringBuilder();
        int digitCount = nums % 10;

        if (digitCount == 9) {
            digits.append("IX");
        } else if (digitCount == 4) {
            digits.append("IV");
        } else if (digitCount < 4) {
            digits.append("I".repeat(Math.max(0, digitCount)));
        }  else {
            digits.append("V");
            digits.append("I".repeat(Math.max(0, digitCount - 5)));
        }

        return digits;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.intToRoman(4)); //IV
        System.out.println(solution.intToRoman(9)); // IX
        System.out.println(solution.intToRoman(58)); //LVIII
        System.out.println(solution.intToRoman(1994)); //MCMXCIV
    }

}
