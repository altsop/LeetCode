package number_of_steps_to_reduce_a_number_to_zero;

// https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
class Solution {

    // Space: O(1)
    // Time: O(n), where n = num.length
    public static int numberOfSteps(int num) {
        int counter = 0;

        while (num != 0) {
            if (isEven(num)) {
                num = num / 2;
            } else {
                num--;
            }
            counter++;
        }

        return counter;
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static void main(String[] args) {
        System.out.println(numberOfSteps(14));
    }

}
