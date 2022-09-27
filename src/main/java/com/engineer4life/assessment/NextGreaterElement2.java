package com.engineer4life.assessment;
import java.util.*;

/**
 * Leetcode: 503 - https://leetcode.com/problems/next-greater-element-ii
 * Difficulty: Medium
 * Time & Space complexity = O(n) & O(n)
 */
public class NextGreaterElement2 {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<Integer>();
        
        // As the greater element can be found in a circular fashion
        // iterating 2n times.
        int times = 0;
        while(times < 2){
            
            for(int idx=0; idx < nums.length; idx++){
                while(!stack.isEmpty() && nums[stack.peek()] < nums[idx]){
                    result[stack.pop()] = nums[idx];
                }

                // storing index instead of value
                // because the index would help us to map
                // the next greater element in to result array
                if(times == 0) stack.push(idx);
            }
            times++;
        }
        
        // if the indices remain in the stack after 2n iterations
        // that means there is no greater element for those indices
        while(!stack.isEmpty()){
            result[stack.pop()] = -1;
        }
        
        return result;
    }
}
