package data_structures.valid_sudoku;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    private static final int BOARD_HEIGHT = 9;
    private static final int BOARD_WEIGHT = 9;

    public boolean isValidSudoku(char[][] board) {
        boolean verticallyValid = isVerticallyValid(board);
        boolean horizontallyValid = isHorizontallyValid(board);
        boolean diagonallyValid = isDiagonallyValid(board);

        return verticallyValid && horizontallyValid && diagonallyValid;
    }

    private boolean isDiagonallyValid(char[][] board) {
        for (int i = 0; i < BOARD_HEIGHT; i++) {
            Set<Character> elements = new HashSet<>();
            int x = i;
            int y = 0;
            while (x >= 0 && y < BOARD_HEIGHT) {
                char element = board[y][x];
                if (element != '.' && elements.contains(element)) {
                    return false;
                }
                elements.add(element);
                x--;
                y++;
            }
        }

        for (int i = 1; i < BOARD_HEIGHT; i++) {
            Set<Character> elements = new HashSet<>();
            int x = i;
            int y = 0;
            while (x >= 0 && y >= 0) {
                char element = board[BOARD_HEIGHT - y][x];
                if (element != '.' && elements.contains(element)) {
                    return false;
                }
                elements.add(element);
                x--;
                y--;
            }
        }

        for (int i = 0; i < BOARD_HEIGHT; i++) {
            Set<Character> elements = new HashSet<>();
            int x = i;
            int y = 0;
            while (x < BOARD_WEIGHT && y < BOARD_HEIGHT) {
                char element = board[y][x];
                if (element != '.' && elements.contains(element)) {
                    return false;
                }
                elements.add(element);
                x++;
                y++;
            }
        }

        for (int i = 0; i < BOARD_HEIGHT; i++) {
            Set<Character> elements = new HashSet<>();
            int x = i;
            int y = 0;
            while (x < BOARD_WEIGHT && y >= 0) {
                char element = board[BOARD_HEIGHT - y][x];
                if (element != '.' && elements.contains(element)) {
                    return false;
                }
                elements.add(element);
                x++;
                y--;
            }
        }


        return true;
    }

    private boolean isHorizontallyValid(char[][] board) {
        for (int i = 0; i < BOARD_HEIGHT; i++) {
            Set<Character> elementsSeen = new HashSet<>();
            for (int j = 0; j < BOARD_WEIGHT; j++) {
                char element = board[i][j];
                if (element != '.' && elementsSeen.contains(element)) {
                    return false;
                }
                elementsSeen.add(element);
            }
        }
        return true;
    }

    private boolean isVerticallyValid(char[][] board) {
        for (int i = 0; i < BOARD_HEIGHT; i++) {
            Set<Character> elementsSeen = new HashSet<>();
            for (int j = 0; j < BOARD_WEIGHT; j++) {
                char element = board[j][i];
                if (element != '.' && elementsSeen.contains(element)) {
                    return false;
                }
                elementsSeen.add(element);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValidSudoku(
                new char[][]{
                        {'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                        , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                        , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                        , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                        , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                        , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                        , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                        , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                        , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                }
        ));
        System.out.println(new Solution().isValidSudoku(
                new char[][]{
                        {'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                        , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                        , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                        , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                        , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                        , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                        , {'.', '.', '.', '.', '.', '.', '2', '8', '.'}
                        , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                        , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                }
        ));
    }

}
