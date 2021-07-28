package beautiful_array;

//For some fixed n, an array nums is beautiful if it is a permutation of the integers 1, 2, ..., n, such that:
//
//For every i < j, there is no k with i < k < j such that nums[k] * 2 = nums[i] + nums[j].
//
//Given n, return any beautiful array nums.  (It is guaranteed that one exists.)

public class Solution {

    private int n;
    private boolean solved;

    public int[] beautifulArray(int n) {
        this.solved = false;
        this.n = n;

        int[] initialArr = composeInitialArr();
        return makePermutation(0, initialArr);
    }

    private int[] makePermutation(int startIndex, int[] initialArr) {
        if (startIndex == n) {
            return initialArr;
        }

        for (int i = startIndex; i < n / 2; i++) {
            for (int j = i + 1; j < n; j++) {
                switchElements(initialArr, i, j);
                if (isValid(initialArr)) {
                    solved = true;
                    return initialArr;
                }

                int[] foundPermutation = makePermutation(startIndex + 1, initialArr);
                if (solved) {
                    return foundPermutation;
                }

                // rollback switch
                switchElements(initialArr, i, j);
            }
        }

        return initialArr;
    }

    public boolean isValid(int[] arr) {
        // nums[k] * 2 = nums[i] + nums[j]
        // i < k < j
        if (n < 3) {
            return true;
        }

        for (int k = 1; k < n - 1; k++) {
            for (int i = 0; i < k; i++) {
                for (int j = i + 2; j < n; j++) {
                    if (arr[k] * 2 == arr[i] + arr[j]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private int[] composeInitialArr() {
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        return arr;
    }

    private void switchElements(int[] arr, int i, int j) {
        int elementAtI = arr[i];
        int elementAtJ = arr[j];

        arr[i] = elementAtJ;
        arr[j] = elementAtI;
    }

}
