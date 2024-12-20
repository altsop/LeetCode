package year_2024.sqrd_69;

class Solution {

    public int mySqrt(int x) {
//        O(logn)

        // 8 /2 = 4
        // 4*4 = 16 > 8 -> move left
        // 4 / 2 = 2
        // 2*2 = 4 < 8 -> move right
        // 3*3 = 9 > 8 -> move left -> 2

     return binarySearch(0, x, x);
    }


    private int binarySearch(int left, int right, int target) {
        final var middle = (right - left) / 2 + left;
        final var square = middle * middle;

        if (square < 0 || square > target) {
            // move left
            return binarySearch(0, middle - 1, target);
        } else if (square < target) {
            if (left == right) {
                return right;
            }
            // move right
            return binarySearch(middle + 1, right, target);
        }

        return middle;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(2147395600));
        System.out.println(solution.mySqrt(1));
        System.out.println(solution.mySqrt(2147395599));
        System.out.println(solution.mySqrt(8));
        System.out.println(solution.mySqrt(4));
        System.out.println(solution.mySqrt(6));
        System.out.println();
    }

}
