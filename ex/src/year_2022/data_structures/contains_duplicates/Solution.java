package year_2022.data_structures.contains_duplicates;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com
// /problems/contains-duplicate/
public class Solution {

    // O(n)
    // O(n - 1) = O(n)
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> processedElements = new HashSet<>();

        for (int num : nums) {
           if (processedElements.contains(num)) {
               return true;
           }

           processedElements.add(num);
        }

        return false;
    }

}
