package year_2022.binary_search;

import java.util.Arrays;

public class Solution {

    public static int search(int[] nums, int target) {
        int[] subarray = nums;
        int skippedElementsAmount = 0;

        while (subarray.length > 1) {
            int middleIndex = subarray.length / 2;
            int middleElement = subarray[middleIndex];

            if (middleElement < target) {
                skippedElementsAmount += middleIndex;
                subarray = Arrays.copyOfRange(subarray, middleIndex, subarray.length);
            } else if (middleElement > target) {
                subarray = Arrays.copyOfRange(subarray, 0, middleIndex);
            } else {
                return skippedElementsAmount + middleIndex;
            }
        }

        return subarray[0] == target ? skippedElementsAmount : -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[] {-1,0,3,5,9,12}, 2));;
        System.out.println(search(new int[] {-1,0,3,5,9,12}, 9));;
        System.out.println(search(new int[] {5}, 9));;
        System.out.println(search(new int[] {5}, 5));;
    }

}
