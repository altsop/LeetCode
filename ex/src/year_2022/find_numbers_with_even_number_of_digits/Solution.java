package year_2022.find_numbers_with_even_number_of_digits;

class Solution {

    public int findNumbers(int[] nums) {
        int counter = 0;

        for (int num : nums) {
            if (hasEvenDigitsNumber(num)) {
                counter++;
            }
        }

        return counter;
    }

    private boolean hasEvenDigitsNumber(int num) {
        String numString = String.valueOf(num);
        int remainder = numString.length() % 2;

        return remainder == 0;
    }

}
