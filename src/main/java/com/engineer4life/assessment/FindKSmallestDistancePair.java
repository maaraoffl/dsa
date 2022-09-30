package com.engineer4life.assessment;

import java.util.*;

/**
 * Leetcode: https://leetcode.com/problems/find-k-th-smallest-pair-distance
 * Difficulty: Hard
 * Time & Space complexity: O(NlogW+NlogN), where NNN is the length of nums, and WWW is equal to nums[nums.length - 1] - nums[0]
 */
public class FindKSmallestDistancePair {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int low = 0;
        int high = nums[nums.length-1] - nums[0];

        while(low < high){
            int mid = (low+high)/2;

            int left=0, count=0;
            for(int right=0; right < nums.length; right++){
                while((nums[right] - nums[left]) > mid) left++;
                count += right-left;
            }
            System.out.printf("low:%d\t mid:%d\t high:%d\t count:%d\n", low, mid, high, count);
            
            if(count >= k) high = mid;
            else low = mid+1;
        }
        // Atlas the result is mid or mid+1, how do you guarantee there will be a distance equals to the mid ?
        // Say if mi is not an actual distance between any pairs in the array and count(mi) >= k,
        // this would mean that count(mi - 1) >= k also since mi doesn't exist in the solution space,
        // and therefore mi would not be the first value to satisfy the condition count >= k.
        return low;
    }

    public static void main(String[] args) {
        var solution = new FindKSmallestDistancePair();
        var test1_nums = new int[]{1,2,5,50};
        var test1_result = solution.smallestDistancePair(test1_nums, 4);
        System.out.println(test1_result);
    }
}
