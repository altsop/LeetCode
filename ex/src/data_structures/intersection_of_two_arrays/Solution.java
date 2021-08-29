package data_structures.intersection_of_two_arrays;

import java.util.*;

//https://leetcode.com/problems/intersection-of-two-arrays-ii/
class Solution {

    // nums1.length = n
    // nums2.length = m
    // time complexity = O(n + m)
    // memory complexity = O(n)
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> frequencies = new HashMap<>();

        // n
        for (int i : nums1) {
            int currentFrequency = frequencies.get(i) != null ? frequencies.get(i) : 0;
            frequencies.put(i, currentFrequency + 1);
        }

        List<Integer> resultAsList = new LinkedList<>();
        // m
        for (int i : nums2) {
            int frequencyInNums1 = frequencies.get(i) != null ? frequencies.get(i) : 0;
            if (frequencyInNums1 > 0) {
                frequencies.put(i, --frequencyInNums1);
                resultAsList.add(i);
            }
        }

        return resultAsList.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().intersect(new int[]{4,9,5}, new int[]{9,4,9,8,4})));
    }

}
