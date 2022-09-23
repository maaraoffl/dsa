package com.engineer4life.assessment;

import java.util.*;

/**
 * Leetcode: https://leetcode.com/problems/make-array-zero-by-subtracting-equal-amounts/
 * Diificulty: Easy
 * Time & Space complexity: O(n) & O(1)
 */

public class MakeArrayZero {
    public int minimumOperations(int[] nums) {
        Set<Integer> data = new HashSet<Integer>();
        
        for (int v : nums) {
            data.add(v);
        }

        /**
         * Rationale: Every unique value in the array requires deduction
         * by its value to the rest of the elements
         */

        return (data.contains(0) ? data.size() -1 : data.size());
    }
}
