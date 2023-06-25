package year_2022.find_pivot_index;

public class Solution {

    public int pivotIndex(int[] nums) {
        int[] leftSums = new int[nums.length];
        int[] rightSums = new int[nums.length];

        fillLeftSums(leftSums, nums);
        fillRightSums(rightSums, nums);

        for (int i = 0; i < nums.length; i++) {
            int rightPivot = rightSums[i];
            int leftPivot = leftSums[i];

            if (rightPivot == leftPivot) {
                return i;
            }
        }

        return -1;
    }

    private void fillLeftSums(int[] sums, int[] initialArray) {
        for (int i = 1; i < initialArray.length; i++) {
            int skippedElement = initialArray[i - 1];
            int allPreviousSum = sums[i - 1];
            sums[i] = skippedElement + allPreviousSum;
        }
    }

    private void fillRightSums(int[] sums, int[] initialArray) {
        for (int i = initialArray.length - 2; i >= 0; i--) {
            int skippedElement = initialArray[i + 1];
            int allPreviousSum = sums[i + 1];
            sums[i] = skippedElement + allPreviousSum;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.pivotIndex(new int[]{1, 7, 3, 6, 5, 6})); // 3
        System.out.println(solution.pivotIndex(new int[]{1, 2, 3})); // -1
        System.out.println(solution.pivotIndex(new int[]{2,1,-1})); // 0
    }

}
