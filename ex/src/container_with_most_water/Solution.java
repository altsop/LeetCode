package container_with_most_water;

// https://leetcode.com/problems/container-with-most-water/
public class Solution {

    // time complexity = O(n^2)
    // memory complexity = O(1)
    public int maxArea(int[] heights) {
        // iterate over all possible permutations of two elements in array
        // memorize the largest and do not proceed if theoretical maximum cannot be overrided
        int largestArea = 0;
        for (int i = 0; i < heights.length; i++) {
            // iteratively choose the second element
            for (int j = i + 1; j < heights.length; j++) {
                int x = j - i;
                int y = findHighestCommonHeight(heights[j], heights[i]);
                largestArea = getLargest(largestArea, x * y);
            }
        }

        return largestArea;
    }

    private int getLargest(int areaA, int areaB) {
        return Math.max(areaA, areaB);
    }

    private int findHighestCommonHeight(int heightA, int heightB) {
        return Math.min(heightA, heightB);
    }

}
