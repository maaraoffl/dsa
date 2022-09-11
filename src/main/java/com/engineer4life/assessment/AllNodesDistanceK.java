package com.engineer4life.assessment;

import java.util.*;

public class AllNodesDistanceK {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
        TreeNode(int x, TreeNode left, TreeNode right){
            val = x;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        var accumulator = new ArrayList<Integer>();
        nodesAfterDistanceK(root, target, k, false, accumulator, new HashSet<>());

        var parentMap = new HashMap<Integer, TreeNode>();
        parentMap.put(root.val, null);
        buildParentMap(root, parentMap);

        nodesBeforeDistanceK(root, target, target, k, parentMap, accumulator);

        System.out.println(accumulator);
        return accumulator;

    }

    void buildParentMap(TreeNode node, Map<Integer, TreeNode> parentMap){
        if(node == null) return;
        if(node.left != null) parentMap.put(node.left.val, node);
        if(node.right != null) parentMap.put(node.right.val, node);
        buildParentMap(node.left, parentMap);
        buildParentMap(node.right, parentMap);
    }

    void nodesBeforeDistanceK(TreeNode root, TreeNode node, TreeNode target, int k, Map<Integer, TreeNode> parentMap, List<Integer> result){
        Set<Integer> visited = new HashSet<>();
        visited.add(node.val);

        while(parentMap.get(node.val) != null){

            if(k==0) result.add(node.val);

            var parent = parentMap.get(node.val);
            if(!visited.contains(parent)) {
                k--;
                visited.add(parent.val);
                node = parent;
            }            
        }       
        if(k > 0) nodesAfterDistanceK(root, target, k, true, result, visited);
    }

    void nodesAfterDistanceK(TreeNode node, TreeNode target, int k, boolean isFound, List<Integer> result, Set<Integer> visited){
        
        if(node == null) return;
        else if(node == target) isFound = true;

        if(isFound){
            if(k == 0 && !visited.contains(node.val)) result.add(node.val);
            k--;
        }

        nodesAfterDistanceK(node.left, target, k, isFound, result, visited);
        nodesAfterDistanceK(node.right, target, k, isFound, result, visited);
    }

    public static void main(String[] args) {
        var problem = new AllNodesDistanceK();
        var t2 = new TreeNode(2, new TreeNode(7), new TreeNode(4));
        var t5 = new TreeNode(5, new TreeNode(6), t2);
        var t1 = new TreeNode(1, new TreeNode(0), new TreeNode(8));
        var root = new TreeNode(3, t5, t1);

        problem.distanceK(root, t5, 2);
    }
}