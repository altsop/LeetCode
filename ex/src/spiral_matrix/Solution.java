package spiral_matrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        int topBoarder = 0;
        int rightBoarder = matrix[0].length - 1;
        int bottomBoarder = matrix.length - 1;
        int leftBoarder = 0;

        List<Integer> spiralOrder = new ArrayList<>();

        while (true) {
            moveFromLeftToRight(matrix, leftBoarder, rightBoarder, topBoarder, spiralOrder);
            moveFromTopToBottom(matrix, topBoarder + 1, bottomBoarder, rightBoarder, spiralOrder);
            if (topBoarder != bottomBoarder) {
                moveFromRightToLeft(matrix, rightBoarder - 1, leftBoarder, bottomBoarder, spiralOrder);
            }

            if (leftBoarder != rightBoarder) {
                moveFromBottomToTop(matrix, bottomBoarder - 1, topBoarder + 1, leftBoarder, spiralOrder);
            }

            topBoarder++;
            rightBoarder--;
            bottomBoarder--;
            leftBoarder++;

            if (topBoarder > bottomBoarder) {
                break;
            }

            if (rightBoarder < leftBoarder) {
                break;
            }
        }

        return spiralOrder;
    }

    private void moveFromBottomToTop(
            int[][] matrix,
            int bottomBoarder,
            int topBoarder,
            int x,
            List<Integer> spiralOrder
    ) {
        int y = bottomBoarder;
        while (y >= topBoarder) {
            int value = matrix[y][x];
            spiralOrder.add(value);
            y--;
        }
    }

    private void moveFromLeftToRight(
            int[][] matrix,
            int leftBoarder,
            int rightBoarder,
            int y,
            List<Integer> spiralOrder
    ) {
        int x = leftBoarder;
        while (x <= rightBoarder) {
            int value = matrix[y][x];
            spiralOrder.add(value);
            x++;
        }
    }

    private void moveFromTopToBottom(
            int[][] matrix,
            int topBoarder,
            int bottomBoarder,
            int x,
            List<Integer> spiralOrder
    ) {
        int y = topBoarder;
        while (y <= bottomBoarder) {
            int value = matrix[y][x];
            spiralOrder.add(value);
            y++;
        }
    }

    private void moveFromRightToLeft(
            int[][] matrix,
            int rightBoarder,
            int leftBoarder,
            int y,
            List<Integer> spiralOrder
    ) {
        int x = rightBoarder;
        while (x >= leftBoarder) {
            int value = matrix[y][x];
            spiralOrder.add(value);
            x--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = new int[3][3];
        matrix[0] = new int[]{1, 2, 3};
        matrix[1] = new int[]{8, 9, 4};
        matrix[2] = new int[]{7, 6, 5};

        System.out.println(solution.spiralOrder(matrix));


        int[][] matrix2 = new int[3][4];
        matrix2[0] = new int[]{1, 2, 3, 4};
        matrix2[1] = new int[]{10, 11, 12, 5};
        matrix2[2] = new int[]{9, 8, 7, 6};

        System.out.println(solution.spiralOrder(matrix2));
    }
}
