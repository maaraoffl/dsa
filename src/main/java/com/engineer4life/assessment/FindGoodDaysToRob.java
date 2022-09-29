package com.engineer4life.assessment;
import java.util.*;

/**
 * Leetcode: 2100: https://leetcode.com/problems/find-good-days-to-rob-the-bank
 * Difficulty: Medium
 * Time & Space complexity: O(n) & O(n)
 */
public class FindGoodDaysToRob {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        var nonIncreasing = new int[security.length];
        for(var leftIndex=1; leftIndex < security.length-time; leftIndex++){
            if(security[leftIndex] > security[leftIndex-1])
                nonIncreasing[leftIndex] = 0;
            else nonIncreasing[leftIndex] = nonIncreasing[leftIndex-1] + 1;
        }
        var nonDecreasing = new int[security.length];
        for(var rightIndex=security.length-2; rightIndex >= time; rightIndex--){
            if(security[rightIndex] > security[rightIndex+1])
                nonDecreasing[rightIndex]=0;
            else nonDecreasing[rightIndex] = nonDecreasing[rightIndex+1]+1;
        }

        var result = new ArrayList<Integer>();
        for(int idx=time; idx < security.length-time; idx++){
            if(nonIncreasing[idx] >= time && nonDecreasing[idx] >= time){
                result.add(idx);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        var solution = new FindGoodDaysToRob();
        var test1_securities = new int[]{5,3,3,3,5,6,2};
        var test1_result = solution.goodDaysToRobBank(test1_securities, 2);
        System.out.println(test1_result);

        var test2_securities = new int[]{1,2,3,4};
        var test2_result = solution.goodDaysToRobBank(test2_securities, 0);
        System.out.println(test2_result);
    }
}
