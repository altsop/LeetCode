package merge_sorted_array;

import java.util.Arrays;

public class Solution {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }

        // 1. compare element from 1 with 2
        // 2. shift if needed
        // 3. fill the rest
        int index1 = 0;
        int index2 = 0;
        while (index1 < m) {
            int element1 = nums1[index1];
            int element2 = nums2[index2];

            if (element1 > element2) {
                // save state before insertion
                int[] shiftedPart = Arrays.copyOfRange(nums1, index1, m + n - 1);

                // insert new
                nums1[index1] = element2;

                // insert shifted
                for (int i = index1 + 1; i < m + n; i++) {
                    nums1[i] = shiftedPart[i - index1 - 1];
                }

                index2++;
            }

            index1++;
        }

        if (index2 < n) {
            for (int i = index2; i < n; i++) {
                nums1[m + i] = nums2[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        merge(nums1, 3, new int[] {2,5,6}, 3);

        System.out.println(Arrays.toString(nums1));
    }

}
