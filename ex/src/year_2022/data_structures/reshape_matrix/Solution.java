package year_2022.data_structures.reshape_matrix;

//https://leetcode.com/problems/reshape-the-matrix/
public class Solution {

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int height = mat.length;
        int width = mat[0].length;

        if (height * width != r * c) {
            return mat;
        }

        int[][] result = new int[r][c];
        int count = 0;

        for (int[] ints : mat) {
            for (int j = 0; j < width; j++) {
                int row = count / c;
                int col = count % c;
                result[row][col] = ints[j];
                count++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
//        var a = new Solution().matrixReshape(new int[][]{{1,2}, {3, 4}}, 1, 4);
        var a = new Solution().matrixReshape(new int[][]{{1,2}, {3, 4}}, 2, 4);
    }

}
