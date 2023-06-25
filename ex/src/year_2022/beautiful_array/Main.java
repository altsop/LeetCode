package year_2022.beautiful_array;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.beautifulArray(4))); // [2, 4, 3, 1] or [2,1,4,3]
        System.out.println(solution.isValid(new int[]{2, 4, 3, 1}));;

        System.out.println(Arrays.toString(solution.beautifulArray(5))); // [3,1,2,5,4] or [2, 4, 3, 1, 5]
        System.out.println(solution.isValid(new int[]{2, 4, 3, 1, 5})); //

        System.out.println(Arrays.toString(solution.beautifulArray(6))); // [4, 6, 2, 1, 5, 3]
        System.out.println(solution.isValid(new int[]{4, 6, 2, 1, 5, 3})); //

        System.out.println(Arrays.toString(solution.beautifulArray(100))); // [4, 6, 2, 1, 5, 3]
//        System.out.println(solution.isValid(new int[]{4, 6, 2, 1, 5, 3})); //
    }

}
