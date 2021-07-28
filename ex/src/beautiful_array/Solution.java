package beautiful_array;

//For some fixed n, an array nums is beautiful if it is a permutation of the integers 1, 2, ..., n, such that:
//
//For every i < j, there is no k with i < k < j such that nums[k] * 2 = nums[i] + nums[j].
//
//Given n, return any beautiful array nums.  (It is guaranteed that one exists.)

public class Solution {

    public int[] beautifulArray(int n) {
        int[] initialArr = composeInitialArr(n);
        return makePermutation(0, initialArr);
    }

    public int[] makePermutation(int startIndex, int[] initialArr) {
        for (int i = startIndex; i < initialArr.length; i++) {
            int[] solution = makePermutation(startIndex + 1, initialArr);
            int[] arrCopy = initialArr.clone();
            if (isValid(arrCopy)) {
                return arrCopy;
            }
            return solution;
        }
        return initialArr;
    }

    public boolean isValid(int[] arr) {
        // nums[k] * 2 = nums[i] + nums[j]
        // i < k < j
        if (arr.length < 3) {
            return true;
        }

        for (int k = 1; k < arr.length - 1; k++) {
            for (int i = 0; i < k; i++) {
                for (int j = i + 2; j < arr.length; j++) {
                    if (arr[k] * 2 == arr[i] + arr[j]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private int[] composeInitialArr(int n) {
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }

        return arr;
    }

}
