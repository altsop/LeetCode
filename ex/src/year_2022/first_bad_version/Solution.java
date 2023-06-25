package year_2022.first_bad_version;

public class Solution {

    public static int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            int pivot = left + (right - left) / 2;
            if (isBadVersion(pivot)) {
                right = pivot;
            } else {
                left = pivot + 1;
            }
        }

        return left;
    }

    private static boolean isBadVersion(int n) {
        return n == 1 || n == 2;
    }

    public static void main(String[] args) {
//        System.out.println(firstBadVersion(1));
        System.out.println(firstBadVersion(4));
    }

}
