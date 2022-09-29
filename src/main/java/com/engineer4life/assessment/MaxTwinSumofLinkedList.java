package com.engineer4life.assessment;

import java.util.*;

/**
 * Leetcode: https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list
 * Difficulty: Medium
 * Time & Space complexity: O(n) & O(n)
 */
public class MaxTwinSumofLinkedList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public int pairSum(ListNode head) {
        Map<ListNode,ListNode> parentMap = new HashMap<ListNode, ListNode>();
        
        ListNode tail = null;
        ListNode start = head;

        // building parent map
        while(start.next != null){
            parentMap.put(start.next, start);
            start = start.next;
        }
        tail = start;
        
        // now resetting the start
        start = head;
        
        int maxTwinSum = 0;
        while(tail.next != start){
            maxTwinSum = Math.max(maxTwinSum, tail.val + start.val);
            start = start.next;
            tail = parentMap.get(tail);
        }
            
        return maxTwinSum;
    }

    public static void main(String[] args) {
        var solution = new MaxTwinSumofLinkedList();
        var test1_head = new ListNode(5,new ListNode(4,new ListNode(2, new ListNode(1))));
        var test1_result = solution.pairSum(test1_head);
        System.out.println(test1_result);
    }
}
