package com.engineer4life.assessment;
import java.util.*;

/**
 * Leetcode: https://leetcode.com/problems/minimum-window-substring
 * Difficulty: Hard
 * Time & Space complexity: O(n) but does not pass LP edge cases
 */

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        var expectedCharMap = new HashMap<Character, Integer>();
        for(var c: t.toCharArray())
            expectedCharMap.put(c, expectedCharMap.getOrDefault(c, 0)+1);

        var expectedUniqueChars = expectedCharMap.keySet().size();
        var expectedTotalChars = expectedCharMap.values().stream().reduce(0, Integer::sum);

        var result = new int[]{0, Integer.MAX_VALUE};
        var currentCharMap = new HashMap<Character, Integer>();
        var currentUniqueChars = 0;
        var currentTotalChars = 0;

        var leftIdx = 0;
        var rightIdx = 0;
        while(rightIdx < s.length()){
            var rightChar = s.charAt(rightIdx);
            
            if(!expectedCharMap.containsKey(rightChar)) {
                rightIdx++;
                continue;
            }

            currentTotalChars++;
            if(!currentCharMap.containsKey(rightChar)){
                currentUniqueChars++;
            }
            currentCharMap.put(rightChar, currentCharMap.getOrDefault(rightChar, 0)+1);
            
            // this condition evaluation is incorrect and fail at edge cases
            while(currentUniqueChars >= expectedUniqueChars && 
                currentTotalChars >= expectedTotalChars && 
                currentCharMap.get(rightChar) == expectedCharMap.get(rightChar)
            ){
                if((rightIdx - leftIdx) < result[1]-result[0]){
                    result[0] = leftIdx;
                    result[1] = rightIdx;
                }

                var leftChar = s.charAt(leftIdx);
                leftIdx++;
                
                if(!expectedCharMap.containsKey(leftChar)) continue;
                
                currentTotalChars--;
                if(currentCharMap.get(leftChar) == 1) {
                    currentUniqueChars--;
                    currentCharMap.remove(leftChar);
                } else currentCharMap.put(leftChar, currentCharMap.get(leftChar)-1);
            }
            rightIdx++;
        }
        if(result[1] == Integer.MAX_VALUE) return "";
        else return s.substring(result[0], result[1]+1);
    }

    public static void main(String[] args) {
        var solution = new MinimumWindowSubstring();

        var test1_s = "ADOBECODEBANC";
        var test1_t = "ABC";
        var test1_result = solution.minWindow(test1_s, test1_t);
        System.out.println(test1_result);

        var test2_s = "AA";
        var test2_t = "AAA";
        var test2_result = solution.minWindow(test2_s, test2_t);
        System.out.println(test2_result);

        var test3_s = "AA";
        var test3_t = "A";
        var test3_result = solution.minWindow(test3_s, test3_t);
        System.out.println(test3_result);

        var test4_s = "A";
        var test4_t = "A";
        var test4_result = solution.minWindow(test4_s, test4_t);
        System.out.println(test4_result);

        var test5_s = "AB";
        var test5_t = "B";
        var test5_result = solution.minWindow(test5_s, test5_t);
        System.out.println(test5_result);

        var test6_s = "AA";
        var test6_t = "AA";
        var test6_result = solution.minWindow(test6_s, test6_t);
        System.out.println(test6_result);

        var test7_s = "BBAA";
        var test7_t = "ABA";
        var test7_result = solution.minWindow(test7_s, test7_t);
        System.out.println(test7_result);
    }
}
