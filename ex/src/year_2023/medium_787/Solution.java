package year_2023.medium_787;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

public class Solution {

    private record Node(
            int nodeValue,
            int priceSoFar
    ) {
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Boolean a = false;
        if (a) {
            System.out.println("----------------");
        }

        int[] minPrice = new int[n];
        Arrays.fill(
                minPrice,
                Integer.MAX_VALUE
        );
        minPrice[src] = 0;

        final Map<Integer, Map<Integer, Integer>> graph = composeGraph(flights);
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(
                src,
                0
        ));

        int depth = 0;
        while (!queue.isEmpty() && depth <= k) {
            int size = queue.size();
            while (size-- > 0) {
                final var current = queue.poll();
                final var neighbours = graph.get(current.nodeValue);
                if (neighbours != null) {
                    for (Map.Entry<Integer, Integer> entry : neighbours.entrySet()) {
                        int neighbourKey = entry.getKey();
                        int neighbourPrice = entry.getValue();
                        int totalPrice = current.priceSoFar + neighbourPrice;
                        if (totalPrice >= minPrice[neighbourKey]) {
                            continue;
                        }
                        minPrice[neighbourKey] = totalPrice;
                        queue.add(new Node(
                                neighbourKey,
                                totalPrice
                        ));
                    }
                }
            }
            depth++;
        }

        return minPrice[dst] == Integer.MAX_VALUE ? -1 : minPrice[dst];
    }

    private Map<Integer, Map<Integer, Integer>> composeGraph(int[][] flights) {
        return Arrays.stream(flights).collect(
                Collectors.groupingBy(
                        flight -> flight[0],
                        Collectors.toMap(
                                flight -> flight[1],
                                flight -> flight[2]
                        )
                )
        );
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.findCheapestPrice(
//                4,
//                new int[][]{new int[]{0, 1, 100}, new int[]{1, 2, 100}, new int[]{2, 0, 100}, new int[]{1, 3, 600}, new int[]{2, 3, 200}},
//                0,
//                3,
//                1
//        ));
//        System.out.println(solution.findCheapestPrice(
//                5,
//                new int[][]{new int[]{4,1,1}, new int[]{1,2,3}, new int[]{0,3,2}, new int[]{0,4,10}, new int[]{3,1,1}, new int[]{1,4,3}},
//                2,
//                1,
//                1
//        ));
        // [0,1,100],[1,2,100],[0,2,500]
//        System.out.println(solution.findCheapestPrice(
//                5,
//                new int[][]{new int[]{0, 1, 100}, new int[]{1, 2, 100}, new int[]{0, 2, 500}},
//                0,
//                2,
//                1
//        ));
        // [0,1,100],[1,2,100],[0,2,500]
//        System.out.println(solution.findCheapestPrice(
//                5,
//                new int[][]{new int[]{0, 1, 1}, new int[]{0, 2, 5}, new int[]{1, 2, 1}, new int[]{2, 3, 1}},
//                0,
//                3,
//                1
//        ));
        //[0,1,1],[0,2,5],[1,2,1],[2,3,1]
        System.out.println(solution.findCheapestPrice(
                5,
                new int[][]{new int[]{4, 1, 1}, new int[]{1, 2, 3}, new int[]{0, 3, 2}, new int[]{0, 4, 10}, new int[]{3, 1, 1}, new int[]{1, 4, 3}},
                2,
                1,
                1
        ));
        // [[4,1,1],[1,2,3],[0,3,2],[0,4,10],[3,1,1],[1,4,3]]
    }

}
