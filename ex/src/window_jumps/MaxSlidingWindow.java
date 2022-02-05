package window_jumps;

import java.util.ArrayDeque;

class MaxSlidingWindow {

    public static ArrayDeque<Integer> findMaxSlidingWindow(int[] arr, int windowSize) {
        ArrayDeque<Integer> result = new ArrayDeque<>();

        for (int i = 0; i < arr.length - windowSize + 1; i++) {
            int[] subArray = makeSubArray(arr, i, i + windowSize);
            int windowMaximum = findMaximum(subArray);
            result.add(windowMaximum);
        }

        return result;
    }

    private static int[] makeSubArray(int[] arr, int start, int end) {
        int[] subArray = new int[end - start];

        for (int i = start; i < end; i++) {
            subArray[end - i - 1] = arr[i];
        }

        return subArray;
    }

    private static int findMaximum(int[] array) {
        int currentMax = array[0];

        for (int currentElement : array) {
            currentMax = Math.max(currentElement, currentMax);
        }

        return currentMax;
    }

}
