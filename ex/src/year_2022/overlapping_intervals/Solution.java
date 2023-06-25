package year_2022.overlapping_intervals;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public class Solution {

    static List<Pair> mergeIntervals(List<Pair> pairs) {
        int i = 0;

        while (i < pairs.size() - 1) {
            Pair current = pairs.get(i);
            Pair nextPair = pairs.get(i + 1);

            if (canBeExpanded(current, nextPair)) {
                Pair merged = new Pair(current.first, nextPair.second);
                pairs.set(i, merged);
                pairs.remove(i + 1);
            } else if (canBeAbsorbed(current, nextPair)) {
                pairs.remove(i + 1);
            } else {
                i++;
            }
        }

        return pairs;
    }

    private static boolean canBeExpanded(Pair a, Pair b) {
        return a.second >= b.first && a.second <= b.second;
    }

    private static boolean canBeAbsorbed(Pair a, Pair b) {
        return a.second >= b.second;
    }

    private static class Pair {

        public int first;
        public int second;

        public Pair(int x, int y) {
            this.first = x;
            this.second = y;
        }

        @Override
        public String toString() {
            return format("%d, %d", first, second);
        }
    }

    public static void main(String[] args) {
        List<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair(1, 5));
        pairs.add(new Pair(6, 8));

        System.out.println(mergeIntervals(pairs));
    }

}
