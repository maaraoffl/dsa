package com.engineer4life.assessment;

/**
 * Leetcode: https://leetcode.com/problems/recover-binary-search-tree
 * Difficulty: Medium
 * Time & Space complexity: O(n) & O(n)
 * 
 * Better solution available: Morris Inorder Traversal
 */

public class RecoverBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
        

    public void recoverTree(TreeNode root) {
        findTwoSwapped(root);
        swapNodeValues(node1, node2);
    };
    
    void swapNodeValues(TreeNode node1, TreeNode node2){
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }

    TreeNode prev = null, node1 = null, node2 = null;
    void findTwoSwapped(TreeNode root){
        if(root == null) return;
        findTwoSwapped(root.left);

        if(prev != null && root.val < prev.val){
            node2 = root;
            if(node1 == null) node1 = prev;
            else return;
        }
        prev = root;
        findTwoSwapped(root.right);
    }
}
