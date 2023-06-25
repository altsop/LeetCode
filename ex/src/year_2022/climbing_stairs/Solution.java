package year_2022.climbing_stairs;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    private static final Map<Integer, Integer> calculated = new HashMap<>();

    static {
        calculated.put(1, 1);
        calculated.put(2, 2);
    }

    public int climbStairs(int target) {
        if (calculated.get(target) == null) {
            int result = climbStairs(target - 1) + climbStairs(target - 2);
            calculated.put(target, result);
        }

        return calculated.get(target);
    }

    public static void main(String[] args) {
        // 2 -> 2
        // 3 -> 3
    }

}
