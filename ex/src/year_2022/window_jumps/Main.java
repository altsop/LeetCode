package year_2022.window_jumps;

import java.util.ArrayDeque;

public class Main {

    public static void main(String[] args) {
        ArrayDeque<Integer> result = MaxSlidingWindow.findMaxSlidingWindow(new int[]{1,2,3, 4,5,6}, 3);
        System.out.println(result);
    }

}
