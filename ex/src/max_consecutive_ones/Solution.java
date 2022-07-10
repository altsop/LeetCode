package max_consecutive_ones;

// Max Consecutive Ones
// https://leetcode.com/explore/learn/card/fun-with-arrays/521/introduction/3238/
class Solution {

    private static final int TARGET = 1;

    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxCounterValue = 0;
        int counter = 0;
        for (int element : nums) {
            if (element == TARGET) {
                counter++;
            } else {
                counter = 0;
            }

            maxCounterValue = Math.max(maxCounterValue, counter);
        }

        return maxCounterValue;
    }


    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[] {1}));
        System.out.println(findMaxConsecutiveOnes(new int[] {1,1,0,1,1,1}));
    }

}
