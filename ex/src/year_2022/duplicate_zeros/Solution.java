package year_2022.duplicate_zeros;

import java.util.Arrays;

public class Solution {

    private static final Integer TARGET = 0;

    public static void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int current = arr[i];
            if (current == TARGET) {
                int[] restOfArray = Arrays.copyOfRange(arr, i + 1, arr.length);
                arr[i + 1] = TARGET;

                for (int j = i + 2; j < arr.length; j++) {
                    arr[j] = restOfArray[j - i - 2];
                }

                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{1,0,2,3,0,4,5,0};
        duplicateZeros(input);

        System.out.println(Arrays.toString(input));
    }

}
