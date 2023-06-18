package medium_45;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int jump(int[] nums) {
        // the same category of exercises...

        // top down:
        // we need to find the best solution to get to 4 in [1, 4] ->
        // we need to find the best solution to get to 1 in [1,1,4] -> 1 -> can we reuse it to get to 4? -> no
        // we need to find the best solution to get to 1 in [3,1,1,4] -> 3 -> can we reuse it to get to 1? -> yes -> can we reuse it to get to 4? -> yes (3,4)
        // the same for 2 in [2,3,1,1,4] - > it has to be longer than previous jump -> don't reuse

        List<Integer> jumps = new ArrayList<>();
        int extraLength = 0;
        int previous = Integer.MIN_VALUE;

        for (int i = nums.length - 2; i > -1; i--) {
            int currentJump = nums[i] - extraLength;
            if (currentJump == 0) {
                extraLength++;
            } else {
                if (!jumps.isEmpty()) {
                    previous = jumps.get(jumps.size() - 1);
                }

                if (currentJump > 0 && currentJump > previous) {
                    int currentJumpCopy = currentJump;
                    for (int j = jumps.size() - 1; j >= 0; j--) {
                        if (currentJumpCopy - jumps.get(j) > 0) {
                            currentJumpCopy -= jumps.get(j);
                            jumps.remove(j);
                        } else {
                            break;
                        }
                    }
                    jumps.add(currentJump + 1 + extraLength - currentJumpCopy);
                    extraLength = 0;
                } else if (currentJump > 0) {
                    jumps.add(extraLength + 1);
                    extraLength = 0;
                } else {
                    extraLength++;
                }
            }
        }
//        return recursiveSearch(
//                nums,
//                nums.length - 2,
//                new ArrayList<>(),
//                0
//        );
        return jumps.size();
    }

    public int jumpV2(int[] nums) {
        int steps = 0, currentStop = 0, currentReach = 0, lastIndex = nums.length - 1;

        for (int i = 0; i < lastIndex; ++i) {
            currentReach = Math.max(currentReach, i + nums[i]);
            if (i == currentStop) {
                steps += 1;
                currentStop = currentReach;
                if (currentStop >= lastIndex) return steps;
            }
        }

        return steps;
    }

//    private int recursiveSearch(int[] nums, int index, List<Integer> jumps, int extraLength) {
//        if (index == -1) {
//            return jumps.size();
//        }
//        int currentJump = nums[index] - extraLength;
//        if (currentJump == 0) {
//            extraLength++;
//        } else {
//            int previous = Integer.MIN_VALUE;
//            if (!jumps.isEmpty()) {
//                previous = jumps.get(jumps.size() - 1);
//            }
//
//            if (currentJump > 0 && currentJump > previous) {
//                int currentJumpCopy = currentJump;
//                for (int i = jumps.size() - 1; i >= 0; i--) {
//                    if (currentJumpCopy - jumps.get(i) > 0) {
//                        currentJumpCopy -= jumps.get(i);
//                        jumps.remove(i);
//                    } else {
//                        break;
//                    }
//                }
//                jumps.add(currentJump + 1 + extraLength - currentJumpCopy);
//                extraLength = 0;
//            } else if (currentJump > 0) {
//                jumps.add(extraLength + 1);
//                extraLength = 0;
//            } else {
//                extraLength++;
//            }
//        }
//
//        return recursiveSearch(
//                nums,
//                index - 1,
//                jumps,
//                extraLength
//        );
//    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.jumpV2(new int[]{2, 3, 1, 1, 4})); // 2
//        System.out.println(solution.jump(new int[]{1, 1, 1, 1})); // 3
//        System.out.println(solution.jump(new int[]{2, 3, 0, 1, 4})); // 2
//        System.out.println(solution.jump(new int[]{2, 0, 2, 0, 1})); // 2
        System.out.println(solution.jumpV2(new int[]{5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0})); // 3
    }

}
