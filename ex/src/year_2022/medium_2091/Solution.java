package year_2022.medium_2091;

public class Solution {

    public int minimumDeletions(int[] nums) {
        int min = Integer.MAX_VALUE;
        int minIndex = 0;

        int max = Integer.MIN_VALUE;
        int maxIndex = 0;

        // find min and max
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (min > current) {
                min = current;
                minIndex = i;
            }

            if (max < current) {
                max = current;
                maxIndex = i;
            }
        }

        int result = 0;
        int totalElements = nums.length;

        if (minIndex < maxIndex) {
            result = findDistance(
                    minIndex,
                    maxIndex,
                    totalElements
            );
        } else {
            result = findDistance(
                    maxIndex,
                    minIndex,
                    totalElements
            );
        }

        return result;
    }

    private int findDistance(int small, int big, Integer total) {
        int result = 0;

        int front = small + 1;
        int back = total - big;

        if (front > back) {
            result += back;
            total -= back;
            back = total - small;
            result += Math.min(
                    front,
                    back
            );
        } else {
            result += front;
            front = big - small;
            result += Math.min(
                    front,
                    back
            );
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.minimumDeletions(new int[]{2, 10, 7, 5, 4, 1, 8, 6}));
//        System.out.println(solution.minimumDeletions(new int[]{0,-4,19,1,8,-2,-3,5}));
//        System.out.println(solution.minimumDeletions(new int[]{101}));
        System.out.println(solution.minimumDeletions(new int[]{-14,61,29,-18,59,13,-67,-16,55,-57,7,74}));
    }

}
