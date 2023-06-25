package year_2022.serach_insert_position;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.searchInsert(
                new int[]{1, 3, 5, 6},
                5
        );

        int result2 = solution.searchInsert(
                new int[]{1, 3, 5, 6},
                2
        );


        int result3 = solution.searchInsert(
                new int[]{1, 3, 5, 6},
                7
        );

        int result4 = solution.searchInsert(
                new int[]{1, 3, 5, 6},
                0
        );

        int result5 = solution.searchInsert(
                new int[]{1, 3, 5, 6},
                1
        );

        System.out.println(result);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middleIndex =  left + ((right - left) / 2);
            int middleElement = nums[middleIndex];

            // what if duplicates? -> no duplicates possible
            if (middleElement > target) {
                // check left side
                right = middleIndex - 1;
            } else if (middleElement < target) {
                // check right side
                left = middleIndex + 1;
            } else {
                // target is found
                return middleIndex;
            }
        }

        return left;
    }

}
