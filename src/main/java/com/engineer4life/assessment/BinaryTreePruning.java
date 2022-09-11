package com.engineer4life.assessment;




public class BinaryTreePruning {

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

    public TreeNode pruneTree(TreeNode root) {
        doesHaveOne(root);
        if(root.val == 0 && root.left == null && root.right == null) return null;
        else return root;
    }

    private boolean doesHaveOne(TreeNode node){
        if(node == null) return false;
        boolean isLeftValid = doesHaveOne(node.left);
        boolean isRightValid = doesHaveOne(node.right);

        if(!isLeftValid) node.left = null;
        if(!isRightValid) node.right = null;
        return (node.val == 1) || isLeftValid || isRightValid;
    }

    public static void main(String[] args) {
        var binaryTreeRight = new TreeNode(0, new TreeNode(0), new TreeNode(1));
        var binaryTree = new TreeNode(1, null, binaryTreeRight);

        var pruner = new BinaryTreePruning();
        pruner.pruneTree(binaryTree);
        System.out.println(binaryTree);
    }
}
