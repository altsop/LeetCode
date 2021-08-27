package findMedianSortedArrays;

// https://leetcode.com/problems/median-of-two-sorted-arrays/
class Solution {

    // run time complexity = O(log (m+n))
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) {
            return 0;
        }

        Double nums1Median = calculateMedian(nums1);
        Double nums2Median = calculateMedian(nums2);
        if (nums1Median == null && nums2Median == null) {
            return 0;
        } else if (nums1Median == null) {
            return nums2Median;
        } else if (nums2Median == null) {
            return nums1Median;
        }

        return (nums1Median + nums2Median) / 2;
    }

    private int[] mergeArrays(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];

        // fill with elements from nums1
        // O(n)
        System.arraycopy(nums1, 0, merged, 0, nums1.length);

        // binary search of a right place for nums2 elements
        for (int i = 0; i < nums2.length; i++) {
            int elementIndex = findIndex(nums2[i], merged);
//            int oldValue = merged[0]
        }
        return merged;
    }

    private int findIndex(int element, int[] target) {
        int currentIndex = target.length / 2;
        boolean wasSmaller = target[currentIndex] > element;

        // 4
        // 1 2 3 5 6
        while (true) {
            if (target[currentIndex] > element) {
                if (!wasSmaller) {
                    return currentIndex;
                }
                wasSmaller = true;
                int shift = currentIndex / 2 == 0 ? 1 : currentIndex / 2;
                currentIndex = currentIndex - shift;
            } else {
                if (wasSmaller) {
                    return currentIndex + 1;
                }

                wasSmaller = false;
                int shift = currentIndex / 2 == 0 ? 1 : currentIndex / 2;
                currentIndex = currentIndex + shift;
            }
        }
    }

    private Double calculateMedian(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        if (nums.length % 2 == 0) {
            // even
            return (double) (nums[nums.length / 2 - 1] + nums[nums.length / 2]) / 2;
        } else {
            // odd
            return (double) nums[nums.length / 2];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 2, 3}, new int[]{1, 2})); //2
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2})); //2
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4})); //2.5
        System.out.println(solution.findMedianSortedArrays(new int[]{0, 0}, new int[]{0, 0})); //2.5
        System.out.println(solution.findMedianSortedArrays(new int[]{}, new int[]{0, 0})); //2.5
        System.out.println(solution.findMedianSortedArrays(new int[]{}, new int[]{1})); //2.5

        System.out.println(solution.findIndex(2, new int[]{1, 3})); // 1
        System.out.println(solution.findIndex(2, new int[]{0, 1, 3})); // 1
    }

}