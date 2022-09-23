package com.engineer4life.assessment;

/**
 * Leetcode: https://leetcode.com/problems/find-triangular-sum-of-an-array
 * Difficulty: Medium
 * Time & Space compleity: O(n^2) & O(1) extra space
 */
public class TriangularSumOfArray {
    public int triangularSum(int[] nums) {
        int size = nums.length;
        while(size > 1){
            for(int idx=0; idx < size-1; idx++){
                nums[idx] = (nums[idx] + nums[idx+1])%10;
            }
            size--;
        }
        return nums[0];
    }

    public static void main(String[] args) {
        var solution = new TriangularSumOfArray();
        var test1_nums = new int[]{1,2,3,4,5};
        var test1_results = solution.triangularSum(test1_nums);
        System.out.println(test1_results);

        var test2_nums = new int[]{5};
        var test2_results = solution.triangularSum(test2_nums);
        System.out.println(test2_results);
    }
}
