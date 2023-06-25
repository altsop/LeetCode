package year_2022.medium_347;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private static class Frequency {
        public int value;
        public int count;
    }

    public int[] topKFrequent(int[] nums, int k) {
        Frequency[] storage = new Frequency[20100];
        List<Frequency> frequencies = new ArrayList<>();

        for (final int num : nums) {
            int index = num + 10000;
            Frequency existing = storage[index];
            if (existing == null) {
                Frequency frequency = new Frequency();
                frequency.value = num;
                frequency.count = 1;
                storage[index] = frequency;
                frequencies.add(frequency);

            } else {
                rebalance(frequencies, existing);
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = frequencies.get(i).value;
        }

        return result;
    }

    private void rebalance(List<Frequency> list, Frequency frequency) {
        if (list.size() == 1) {
            frequency.count++;
            return;
        }

        list.remove(frequency);
        frequency.count++;

        int left = 0;
        int right = list.size();
        while (left < right) {
            int pivot = left + (right - left) / 2;
            final int pivotCount = list.get(pivot).count;
            if (pivotCount > frequency.count) {
                left = pivot + 1;
            } else if (pivotCount < frequency.count) {
                right = pivot;
            } else {
                break;
            }
        }

        int index = left + (right - left) / 2;
        list.add(index, frequency);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.topKFrequent(new int[]{-1,1,4,-4,3,5,4,-2,3,-1}, 3));
//        System.out.println(solution.topKFrequent(new int[]{3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6}, 1));
//        System.out.println(solution.topKFrequent(new int[] {1,1,1,2,2,3,3,3}, 2));
//        System.out.println(solution.topKFrequent(new int[] {1}, 1));
    }

}
