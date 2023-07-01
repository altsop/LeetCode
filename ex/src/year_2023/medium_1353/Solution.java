package year_2023.medium_1353;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    record Event(
            int start,
            int end
    ) {
    }

    public int maxEvents(int[][] events) {
        if (events == null || events.length == 0) return 0;
        final int N = events.length;
        // Sort events by start day.
        Arrays.sort(events, Comparator.comparingInt(e -> e[0]));
        // Store end days of in progress events in min heap.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // Join the earliest ending in progress evetns from the earliest start event to the latest start event.
        int i = 0, day = 0, res = 0;
        while (i < N || !pq.isEmpty()) {
            // Get current date.
            if (pq.isEmpty()) {
                day = events[i][0];
            }
            // Add just started events at current day in the min heap.
            while (i < N && day == events[i][0]) {
                pq.add(events[i][1]);
                i++;
            }
            // Join the earliest ending event.
            pq.poll();
            res++;
            day++;
            // Remove already ended events.
            while (!pq.isEmpty() && day > pq.peek()) {
                pq.poll();
            }
        }
        return res;
    }

//    public int maxEvents(int[][] events) {
//        final List<Event> list = Arrays.stream(events).map(event -> new Event(
//                        event[0],
//                        event[1]
//                ))
//                .sorted(Comparator.comparingInt(Event::start))
//                .toList();
//
//        Queue<Event> queue = new PriorityQueue<>(
//                Comparator.comparingInt(event -> event.end - event.start)
//        );
//
//        queue.addAll(list);
//
//        int lastEnd = queue.poll().end;
//        int count = 1;
//
//        while (!queue.isEmpty()) {
//            final Event event = queue.poll();
//            if (event.start >= lastEnd) {
//                lastEnd = event.end;
//                count++;
//            }
//        }
//
//        return count;
//    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxEvents(new int[][]{new int[]{1, 2}, new int[]{2, 2}, new int[]{3, 4}, new int[]{1, 2}}));
        ;
    }
}
