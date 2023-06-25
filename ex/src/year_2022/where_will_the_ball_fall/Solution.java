package year_2022.where_will_the_ball_fall;

import java.util.Arrays;

public class Solution {

    public int[] findBall(int[][] grid) {
        int width = grid[0].length;
        int height = grid.length;

        int[] result = new int[width];

        for (int column = 0; column < width; column++) {
            int y = 0;
            int x = column;
            boolean upper = true;

            while (y < height) {
                int value = grid[y][x];
                if (upper) {
                    if (value == 1) {
                        x++;
                    } else {
                        x--;
                    }

                    if (x < 0 || x == width) {
                        break;
                    }

                    int adjacent = grid[y][x];
                    if (adjacent != value) {
                        break;
                    }
                }

                if (!upper) {
                    y++;
                }
                upper = !upper;
            }

            int resultValue = -1;
            if (y == height) {
                resultValue = x;
            }
            result[column] = resultValue;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] grid = new int[5][5];
        grid[0] = new int[]{1, 1, 1, -1, -1};
        grid[1] = new int[]{1, 1, 1, -1, -1};
        grid[2] = new int[]{-1, -1, -1, 1, 1};
        grid[3] = new int[]{1, 1, 1, 1, -1};
        grid[4] = new int[]{-1, -1, -1, -1, -1};

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.findBall(grid)));

        int[][] grid2 = new int[1][1];
        grid2[0] = new int[]{-1};
        System.out.println(Arrays.toString(solution.findBall(grid2)));

        int[][] grid3 = new int[4][5];
        grid3[0] = new int[]{1, 1, 1, 1, 1, 1};
        grid3[1] = new int[]{-1, -1, -1, -1, -1, -1};
        grid3[2] = new int[]{1, 1, 1, 1, 1, 1};
        grid3[3] = new int[]{-1, -1, -1, -1, -1, -1};
        System.out.println(Arrays.toString(solution.findBall(grid3)));
    }

}
