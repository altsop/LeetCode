package year_2022.unique_paths;

public class Solution {

    public int uniquePaths(int m, int n) {
        if (m == 1  ||  n == 1) {
            return 1;
        }

        int[][] minPaths = new int[m][n];

        return findMinPath(minPaths, n - 2, m - 1) + findMinPath(minPaths, n - 1, m - 2);
    }

    private int findMinPath(int[][] minPaths, int x, int y) {
        if (x == 0 || y == 0) {
            return 1;
        } else if (minPaths[y][x] != 0) {
            return minPaths[y][x];
        }

        int value = findMinPath(minPaths, x - 1, y) + findMinPath(minPaths, x, y - 1);
        minPaths[y][x] = value;

        return value;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.uniquePaths(2, 1));
        System.out.println(solution.uniquePaths(51, 9));
        System.out.println(solution.uniquePaths(3, 7));
    }

}
