package year_2022.reverse_integer;

public class Main {

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        System.out.println(solution.reverse(123));
//        System.out.println(solution.reverse(-123));
//        System.out.println(solution.reverse(120));
//        System.out.println(solution.reverse(0));
//        System.out.println(solution.reverse(Integer.MAX_VALUE));

        Solution2 solution2 = new Solution2();
//        System.out.println(solution2.reverse(123));
//        System.out.println(solution2.reverse(-123));
//        System.out.println(solution2.reverse(120));
//        System.out.println(solution2.reverse(0));
//        System.out.println(solution2.reverse(Integer.MAX_VALUE));
        System.out.println(solution2.reverse(-2147483648));
        System.out.println(solution2.reverse(-2147483412));

    }

}
