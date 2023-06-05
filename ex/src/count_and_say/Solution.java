package count_and_say;

public class Solution {

    private static long[] MEMORY = new long[30];

    static {
        MEMORY[0] = 1;
    }

    public String countAndSay(int n) {
        if (MEMORY[n - 1] != 0) {
            return String.valueOf(MEMORY[n - 1]);
        }

        String previous = countAndSay(n - 1);

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < previous.length(); i++) {
            char current = previous.charAt(i);
            int amount = 1;
            for (int j = i + 1; j < previous.length(); j++) {
                int next = previous.charAt(j);
                if (current != next) {
                    break;
                }
                amount++;
            }

            i += amount - 1;
            builder.append(amount).append(current);
        }

//        MEMORY[n - 1] = Long.parseLong(builder.toString());
        return builder.toString();
    }

    public static void main(String[] args) {
        final Solution solution = new Solution();
        System.out.println(solution.countAndSay(1));
        System.out.println(solution.countAndSay(2));
        System.out.println(solution.countAndSay(3));
        System.out.println(solution.countAndSay(4));
        System.out.println(solution.countAndSay(5));
    }


}
