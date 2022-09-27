package com.engineer4life.assessment;

import java.util.*;

/**
 * Leetcode: https://leetcode.com/problems/generate-parentheses
 * Difficulty: Medium
 * Time & Space complexity: Catalan number
 */
public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        generate(new StringBuilder(""), n, n, result);
        return result;
    }

    void generate(StringBuilder str, int nLeft, int nRight, List<String> result){
        if(nLeft > 0){
            str.append("(");
            generate(str , nLeft-1, nRight, result);
            str.deleteCharAt(str.length() -1);
        }
        if(nRight > nLeft){
            str.append(")");
            generate(str, nLeft, nRight-1, result);
            str.deleteCharAt(str.length() -1);
        }
        if(nRight == 0 && nLeft == 0) result.add(str.toString());
    }
    
    public static void main(String[] args) {
        var solution = new GenerateParenthesis();
        var test1_result = solution.generateParenthesis(3);
        System.out.println(test1_result);
    }
}
