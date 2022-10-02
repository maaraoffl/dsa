package com.engineer4life.assessment;

/**
 * Leetcode: https://leetcode.com/problems/maximum-subarray
 * Difficulty: Medium
 * Time & Space complexity: O(n) & O(1)
 */
public class MaximumSubArray {
    public int maxSubArray(int[] nums) {
        
        int max = Integer.MIN_VALUE;
        
        /**
         * currentSubSum is initialized with 0 here
         * instead of Integer.MIN_VALUE because currentSubSum
         * wil become higher positive integer(integer overflow)
         * when adding Integer.MIN_VALUE with a negative number.
         */
        int currentSubSum = 0;
        
        for(int num: nums){

            // if currentSubSum is less than num
            // then subarray of just num itself will do good
            if(num+currentSubSum < num){
                currentSubSum = num;
            } else {
                currentSubSum += num;                
            }
            max = Math.max(max, currentSubSum);
        }
        return max;
    }

 
    // This implementation produce the same output, more concise
    // but could be little cryptic.
    public int otherMaxSubArray(int[] nums) {
        
        int max = Integer.MIN_VALUE;
        int currentSubSum = 0;
        
        for(int num: nums){            
            currentSubSum = Math.max(num, num+currentSubSum);
            max = Math.max(max, currentSubSum);
        }
        return max;
    }
}