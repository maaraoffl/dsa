package com.engineer4life.assessment;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LowestCommonAncestor {

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int val){
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        var parentMap = new HashMap<TreeNode, TreeNode>();
        parentMap.put(root, null);
        buildParentMap(root, parentMap);

        // Store all p's ancestors in a set
        var ancestors = new HashSet<TreeNode>();

        // Beware p could be an ancestor as well
        ancestors.add(p);
        while(p != null){
            var parent = parentMap.getOrDefault(p, null);
            if(parent == null) break;
            ancestors.add(parent);
            p = parent;
        }

        while(!ancestors.contains(q)){
            q = parentMap.getOrDefault(q, null);
            if(q == null) break;
        }
        return q;
    }

    static void buildParentMap(TreeNode node, Map<TreeNode, TreeNode> parentMap){
        if(node == null) return;
        if(node.left != null) parentMap.put(node.left, node);
        if(node.right != null) parentMap.put(node.right, node);
        buildParentMap(node.left, parentMap);
        buildParentMap(node.right, parentMap);
    }

    public static void main(String[] args) {

        var p = new TreeNode(6);
        var q = new TreeNode(7);
        var t2 = new TreeNode(2, q, new TreeNode(4));
        var t1 = new TreeNode(1, new TreeNode(0), new TreeNode(8));
        var t5 = new TreeNode(5, p, t2);
        var root = new TreeNode(3, t5, t1);

        var result = lowestCommonAncestor(root, p, q);
        System.out.println(result.val);
    }
}
