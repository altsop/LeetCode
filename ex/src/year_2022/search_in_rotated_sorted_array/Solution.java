package year_2022.search_in_rotated_sorted_array;

public class Solution {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        return binarySearch(left, right, nums, target);
    }

    private int binarySearch(int left, int right, int[] nums, int target) {
        int pivot = (left + right) / 2;
        int pivotValue = nums[pivot];

        if (pivotValue == target) {
            return pivot;
        }

        if (left > right) {
            return -1;
        }

        if (nums[left] > target) {
            // move to the right
            if (isValidBranch(pivot + 1, right, nums, target)) {
                return binarySearch(pivot + 1, right, nums, target);
            }
        } else if (nums[right] < target) {
            // move to the left
            if (isValidBranch(left, pivot - 1, nums, target)) {
                return binarySearch(left, pivot - 1, nums, target);
            }
        }

        // common binary search
        if (pivotValue < target) {
            // right
            return binarySearch(pivot + 1, right, nums, target);
        } else {
            // left
            return binarySearch(left, pivot - 1, nums, target);
        }
    }

    private boolean isValidBranch(int left, int right, int[] nums, int target) {
        if (right > 0 && left < nums.length - 1) {

            int leftElement = nums[left];
            int rightElement = nums[right];

            // therefore we handle sorted part
            if (leftElement <= rightElement) {
                return rightElement >= target && leftElement <= target;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.search(new int[]{2,3,4,5,6,7,8,9,1}, 9)); // 1
//        System.out.println(solution.search(new int[]{5,1,2,3,4}, 1)); // 1
//        System.out.println(solution.search(new int[]{1,3}, 4)); // -1
//        System.out.println(solution.search(new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 8)); // 4
//        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0)); // 4
//        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3)); // -1
//        System.out.println(solution.search(new int[]{1}, 0)); // -1
    }
}
