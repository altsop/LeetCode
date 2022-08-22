package flood_fill;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int[][] floodFill(int[][] image, int startY, int startX, int color) {
        Queue<Coordinates> coordinatesQueue = new LinkedList<>();
        coordinatesQueue.add(new Coordinates(startX, startY));
        int friendlyColor = image[startY][startX];

        while (!coordinatesQueue.isEmpty()) {
            Coordinates current = coordinatesQueue.poll();
            image[current.y][current.x] = color;

            if (current.y > 0) {
                Coordinates top = new Coordinates(current.x, current.y - 1);
                if (shouldVisit(top, image, color, friendlyColor)) {
                    coordinatesQueue.add(top);
                }
            }

            if (current.y < image.length - 1) {
                Coordinates bottom = new Coordinates(current.x, current.y + 1);
                if (shouldVisit(bottom, image, color, friendlyColor)) {
                    coordinatesQueue.add(bottom);
                }
            }

            if (current.x > 0) {
                Coordinates left = new Coordinates(current.x - 1, current.y);
                if (shouldVisit(left, image, color, friendlyColor)) {
                    coordinatesQueue.add(left);
                }
            }

            if (current.x < image[current.y].length - 1) {
                Coordinates right = new Coordinates(current.x + 1, current.y);
                if (shouldVisit(right, image, color, friendlyColor)) {
                    coordinatesQueue.add(right);
                }
            }
        }

        return image;
    }

    private boolean shouldVisit(Coordinates coordinates, int[][] image, int color, int friendlyColor) {
        int coordinatesColor = image[coordinates.y][coordinates.x];
        return coordinatesColor != color && coordinatesColor == friendlyColor;
    }

    private static class Coordinates {

        int x;
        int y;

        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] image = new int[3][3];
        image[0] = new int[]{1, 1, 1};
        image[1] = new int[]{1, 1, 0};
        image[2] = new int[]{1, 0, 1};

        solution.floodFill(image, 1, 1, 2);
    }

}
