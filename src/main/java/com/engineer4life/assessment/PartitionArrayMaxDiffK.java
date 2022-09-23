package com.engineer4life.assessment;

import java.util.Arrays;

/**
 * Leetcode: https://leetcode.com/problems/partition-array-such-that-maximum-difference-is-k
 * Difficulty: Medium
 * Time & Space complexity: O(nlogn) & 0(1)
 */
public class PartitionArrayMaxDiffK {
    public int partitionArray(int[] nums, int k) {

        /**
         * Though the problem is about a subsequence (i.e. returning number of subsequences
         * that are k values apart), we can change the order via sorting since we are not
         * returning subsequnces. In addition, sorting help us to demark the K ranges between
         * elements. 
         */
        Arrays.sort(nums);

        int result = 0;
        
        int min = nums[0];
        result++;

        for(var idx=1; idx< nums.length; idx++){
            if(nums[idx]-min > k){
                result++;
                min = nums[idx];
            }
        }
        return result;
    }

    public int otherPartitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int result = 0;

        // Given the input is always greater than -1
        int range = -1;

        for(int num: nums){
            if(num > range){
                result++;
                range = num + k;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        var solution = new PartitionArrayMaxDiffK();
        var test1_nums = new int[]{3,6,1,2,5};
        var test1_result = solution.partitionArray(test1_nums, 2);
        System.out.println(test1_result);

        var test2_nums = new int[]{2,2,4,5};
        var test2_result = solution.partitionArray(test2_nums, 0);
        System.out.println(test2_result);

        var test3_nums = new int[]{1,2,3};
        var test3_result = solution.partitionArray(test3_nums, 1);
        System.out.println(test3_result);
    }
}
