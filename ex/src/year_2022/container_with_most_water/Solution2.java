package year_2022.container_with_most_water;

public class Solution2 {

    // time complexity = O(n)
    // memory complexity = O(1)
    public int maxArea(int[] heights) {
        int largestArea = 0;
        int leftElementIndex = 0;
        int rightElementIndex = heights.length - 1;

        while (leftElementIndex < rightElementIndex) {
            int x = rightElementIndex - leftElementIndex;
            int y = findHighestCommonHeight(heights[leftElementIndex], heights[rightElementIndex]);
            largestArea = getLargest(largestArea, x * y);

            if (heights[leftElementIndex] < heights[rightElementIndex]) {
                leftElementIndex++;
            } else {
                rightElementIndex--;
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

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.maxArea(new int[]{1, 5, 4, 3})); // 6
        System.out.println(solution2.maxArea(new int[]{3, 1, 2, 4, 5})); // 12
    }

}
