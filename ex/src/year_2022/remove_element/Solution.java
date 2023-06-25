package year_2022.remove_element;

public class Solution {

    public int removeElement(int[] nums, int val) {
        int length = 0;

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (current != val) {
                nums[length] = current;
                length++;
            }
        }

        return length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeElement(new int[]{3, 2, 2, 3}, 3));
        ;
    }

}
