package number_of_islands;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {

    public int numIslands(char[][] grid) {
        Queue<Coordinate> coordinates = new LinkedList<>();
        Set<Coordinate> visited = new HashSet<>();
        int islandNumber = 0;

        for (int y = 0; y < grid.length; y++) {
            char[] row = grid[y];

            for (int x = 0; x < row.length; x++) {
                Coordinate coordinate = new Coordinate(x, y);
                if (!visited.contains(coordinate) && row[x] != '0') {
                    coordinates.add(coordinate);
                    visited.add(coordinate);

                    bfs(grid, coordinates, visited);
                    islandNumber++;
                }
            }
        }

        return islandNumber;
    }

    private void bfs(char[][] grid, Queue<Coordinate> coordinates, Set<Coordinate> visited) {
        while (!coordinates.isEmpty()) {
            Coordinate current = coordinates.poll();
            int value = grid[current.y][current.x];
            if (value == '0') {
                continue;
            }

            if (current.y > 0) {
                Coordinate top = new Coordinate(current.x, current.y - 1);
                if (!visited.contains(top)) {
                    coordinates.add(top);
                    visited.add(top);
                }
            }

            if (current.y < grid.length - 1) {
                Coordinate bottom = new Coordinate(current.x, current.y + 1);
                if (!visited.contains(bottom)) {
                    coordinates.add(bottom);
                    visited.add(bottom);
                }
            }

            if (current.x > 0) {
                Coordinate left = new Coordinate(current.x - 1, current.y);
                if (!visited.contains(left)) {
                    coordinates.add(left);
                    visited.add(left);
                }
            }

            if (current.x < grid[current.y].length - 1) {
                Coordinate right = new Coordinate(current.x + 1, current.y);
                if (!visited.contains(right)) {
                    coordinates.add(right);
                    visited.add(right);
                }
            }
        }
    }

    private static class Coordinate {

        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            Coordinate other = (Coordinate) obj;
            return other.x == this.x && other.y == this.y;
        }

        @Override
        public int hashCode() {
            return y * 10 + x;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] grid = new char[4][5];
        grid[0] = new char[]{'1', '1', '1', '1', '0'};
        grid[1] = new char[]{'1', '1', '0', '1', '0'};
        grid[2] = new char[]{'1', '1', '0', '0', '0'};
        grid[3] = new char[]{'0', '0', '1', '1', '1'};

        System.out.println(solution.numIslands(grid));
    }


}
