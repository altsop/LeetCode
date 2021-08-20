package easy_1_two_sum;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution solution1 = new Solution();
        System.out.println(Arrays.toString(solution1.twoSum(new int[]{2, 7, 11, 15}, 9)));

        Solution2 solution2 = new Solution2();
        System.out.println(Arrays.toString(solution2.twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

}
