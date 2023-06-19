package medium_34;

public class Solution {

    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        int[] result = new int[]{-1, -1};

        boolean targetIsFound = false;
        int pivot = 0;

        while (left <= right) {
            pivot = calculatePivot(
                    left,
                    right
            );
            int pivotElement = nums[pivot];

            if (pivotElement > target) {
                right = pivot - 1;
            } else if (pivotElement < target){
                left = pivot + 1;
            } else {
                targetIsFound = true;
                break;
            }
        }

        if (targetIsFound) {
            int rightMost = findRightMost(pivot, nums);
            int leftMost = findLeftMost(pivot, nums);

            result[0] = leftMost;
            result[1] = rightMost;
        }
        return result;
    }

    private int findRightMost(int start, int[] nums) {
        int target = nums[start];

        int left = start;
        int right = nums.length - 1;
        int pivot = 0;
        while (left <= right) {
            pivot = calculatePivot(left, right);
            int pivotElement = nums[pivot];
            if (pivotElement > target) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }

        return right;
    }

    private int findLeftMost(int end, int[] nums) {
        int target = nums[end];

        int left = 0;
        int right = end;
        int pivot = 0;
        while (left <= right) {
            pivot = calculatePivot(left, right);
            int pivotElement = nums[pivot];
            if (pivotElement < target) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }

        return left;
    }

    private int calculatePivot(int left, int right) {
        return left + (right - left) / 2;
    }

    public static void main(String[] args) {
        // Input: nums = [5,7,7,8,8,10], target = 8
        // Output: [3,4]
        Solution solution = new Solution();
        solution.searchRange(
                new int[]{5, 7, 7, 8, 8, 10},
                8
        );
    }

}
