package data_structures.merge_sorted_arrays;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int currentIndex = 0;
        Queue<Integer> freeElements = new LinkedList<>();

        while (currentIndex < (m + n)) {

            int valueFromNum1 = Integer.MAX_VALUE;
            if (i < m) {
                if (freeElements.isEmpty()) {
                    valueFromNum1 = nums1[i];
                } else {
                    valueFromNum1 = freeElements.peek();
                }
            }

            int valueFromNum2 = j < n ? nums2[j] : Integer.MAX_VALUE;

            if (valueFromNum2 > valueFromNum1) {
                if (!freeElements.isEmpty()) {
                    freeElements.poll();
                }
                if (currentIndex > i) {
                    freeElements.add(nums1[currentIndex]);
                }

                nums1[currentIndex] = valueFromNum1;
                i++;
            } else {
                if (currentIndex >= i) {
                    freeElements.add(nums1[currentIndex]);
                }

                nums1[currentIndex] = valueFromNum2;
                j++;
            }

            currentIndex++;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.merge(new int[]{1, 3, 5, 0, 0, 0}, 3, new int[]{2, 4, 6}, 3);
        solution.merge(new int[]{4, 5, 6, 0, 0, 0}, 3, new int[]{1, 2, 3}, 3);
    }

}
