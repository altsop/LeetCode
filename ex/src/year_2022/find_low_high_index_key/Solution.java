package year_2022.find_low_high_index_key;

import java.util.List;

public class Solution {

    static int findLowIndex(List<Integer> arr, int keyValue) {
        return binarySearchOfLowIndexUsingWhile(arr, keyValue);
    }

    private static int binarySearchOfLowIndex(List<Integer> arr, int keyValue, int startIndex, int endIndex) {
        int middleIndex = (startIndex + endIndex + 1) / 2;
        int middleValue = arr.get(middleIndex);

        if (startIndex == endIndex) {
            return middleValue == keyValue ? middleIndex : -2;
        }

        if (middleValue >= keyValue) {
            return binarySearchOfLowIndex(arr, keyValue, startIndex, middleIndex);
        }

        return binarySearchOfLowIndex(arr, keyValue, middleIndex + 1, endIndex);
    }

    private static int binarySearchOfLowIndexUsingWhile(List<Integer> arr, int keyValue) {
        int startIndex = 0;
        int endIndex = arr.size() - 1;
        int middleIndex = (startIndex + endIndex) / 2;

        while (startIndex < endIndex) {
            int middleValue = arr.get(middleIndex);

            if (middleValue >= keyValue) {
                endIndex = middleIndex - 1;
            } else {
                startIndex = middleIndex + 1;
            }

            middleIndex = (startIndex + endIndex) / 2;
        }

        return startIndex < arr.size() && arr.get(startIndex) == keyValue ? startIndex : -1;
    }

    static int findHighIndex(List<Integer> arr, int key) {
        return binarySearchOfHighIndex(arr, key, 0, arr.size());
    }

    private static int binarySearchOfHighIndex(List<Integer> arr, int keyValue, int startIndex, int endIndex) {
        int middleIndex = (startIndex + endIndex + 1) / 2;
        int middleValue = arr.get(middleIndex);

        if (startIndex == endIndex) {
            return middleValue == keyValue ? middleIndex : -2;
        }

        if (middleValue <= keyValue) {
            return binarySearchOfHighIndex(arr, keyValue, middleIndex, endIndex);
        }

        return binarySearchOfHighIndex(arr, keyValue, startIndex, middleIndex - 1);
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 6, 6);
        System.out.println(findLowIndex(list, 2));
        System.out.println(findHighIndex(list, 2));
    }

}
