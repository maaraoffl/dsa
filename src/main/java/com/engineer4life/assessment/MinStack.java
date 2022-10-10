package com.engineer4life.assessment;

import java.util.*;

/**
 * Leetcode: https://leetcode.com/problems/min-stack
 * Difficulty: Medium
 * Time & Space complexity: O(1) & O(n)
 */
public class MinStack {
    static class Item {
        int val;
        int min;
        
        Item(int val, int min){
            this.val = val;
            this.min = min;
        }
    }
    
    // Used stack for preserving the order and
    // maintain min value in stack at each data frame
    Stack<Item> stack;

    public MinStack() {
        stack = new Stack<Item>();
    }
    
    public void push(int val) {
        int min = Integer.MAX_VALUE;
        if(!stack.isEmpty()){
            min = stack.peek().min;
        }
        
        stack.push(new Item(val, Math.min(min, val)));
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().val;
    }
    
    public int getMin() {
        return stack.peek().min;
    }
}
