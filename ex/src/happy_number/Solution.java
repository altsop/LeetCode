package happy_number;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public boolean isHappy(int n) {
        int processed = n;
        Set<Integer> processedElements = new HashSet<>();
        while (true) {
            int sum = 0;
            while (processed > 0) {
                sum += Math.pow((double) processed % 10, 2);
                processed /= 10;
            }

            processed = sum;
            if (processed == 1) {
                return true;
            }

            if (processedElements.contains(processed)) {
                return false;
            }

            processedElements.add(processed);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isHappy(7));
        System.out.println(solution.isHappy(19));
        System.out.println(solution.isHappy(2));
    }

}
