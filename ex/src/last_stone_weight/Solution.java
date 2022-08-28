package last_stone_weight;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public int lastStoneWeight(int[] stones) {
        List<Integer> remainedStones = Arrays.stream(stones).boxed().collect(Collectors.toList());

        while (remainedStones.size() > 1) {
            Collections.sort(remainedStones);
            int maxElement = remainedStones.get(remainedStones.size() - 1);
            int previousMaxElement = remainedStones.get(remainedStones.size() - 2);

            remainedStones.remove(remainedStones.size() - 1);
            remainedStones.remove(remainedStones.size() - 1);

            if (maxElement != previousMaxElement) {
                remainedStones.add(maxElement - previousMaxElement);
            }
        }

        return remainedStones.size() == 0 ? 0 : remainedStones.get(0);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lastStoneWeight(new int[] {2,7,4,1,8,1}));
        System.out.println(solution.lastStoneWeight(new int[] {1}));
    }

}
