package year_2022.fibonacci_number;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    private static final Map<Integer, Integer> calculated = new HashMap<>();

    static {
        calculated.put(0, 0);
        calculated.put(1, 1);
    }

    public int fib(int target) {
        if (calculated.get(target) == null) {
            int result = fib(target - 1) + fib(target - 2);
            calculated.put(target, result);
        }

        return calculated.get(target);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fib(10));;
    }

}
