package container_with_most_water;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7})); // 49
        System.out.println(solution.maxArea(new int[]{1,1})); // 1
        System.out.println(solution.maxArea(new int[]{4,3,2,1,4})); // 16
        System.out.println(solution.maxArea(new int[]{1,2,1})); // 2
    }

}
