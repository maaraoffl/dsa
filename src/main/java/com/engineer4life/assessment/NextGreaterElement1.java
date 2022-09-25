package com.engineer4life.assessment;

import java.util.*;

/**
 * Leetcode: https://leetcode.com/problems/next-greater-element-i
 * Difficulty: Easy
 * Time & Space complexity: O(N) & O(N), N refers to nums2
 */

public class NextGreaterElement1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        var stack = new Stack<Integer>();
        var nextGreaterMap = new HashMap<Integer, Integer>();
        for(var num : nums2){
            while(!stack.isEmpty() && stack.peek() < num) {
                int element = stack.pop();
                nextGreaterMap.put(element, num);
            }
            stack.push(num);
        }

        var result = new int[nums1.length];
        var count=0;
        for(var num: nums1){
            result[count++] = nextGreaterMap.getOrDefault(num, -1);

        }
        return result;
    }

    public static void main(String[] args) {
        var solution = new NextGreaterElement1();
        
        var test1_nums1 = new int[]{4,1,2};
        var test1_nums2 = new int[]{1,3,4,2};
        var test1_results = solution.nextGreaterElement(test1_nums1, test1_nums2);
        for(int result : test1_results){
            System.out.printf("%d, ", result);
        }
        
        // line break
        System.out.println();

        var test2_nums1 = new int[]{2, 4};
        var test2_nums2 = new int[]{1, 2, 3, 4};
        var test2_results = solution.nextGreaterElement(test2_nums1, test2_nums2);
        for(int result : test2_results){
            System.out.printf("%d, ", result);
        }

        // line break
        System.out.println();

        var test3_nums1 = new int[]{1,3,5,2,4};
        var test3_nums2 = new int[]{6,5,4,3,2,1,7};
        var test3_results = solution.nextGreaterElement(test3_nums1, test3_nums2);
        for(int result : test3_results){
            System.out.printf("%d, ", result);
        }
    }
}
