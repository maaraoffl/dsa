package com.engineer4life.assessment;

import java.util.*;

public class NAryTreeLevelTraversal {
    static class Node {
        public int val;
        public List<Node> children;
    
        public Node() {}
    
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    static class NodePair{
        Node node; int level;
        NodePair(Node node, int level){
            this.node = node;
            this.level = level;
        }
    }
    
    public List<List<Integer>> levelOrder(Node root) {

        var levelOrder = new ArrayList<List<Integer>>();

        Queue<Node> nodeQueue = new ArrayDeque<Node>();
        nodeQueue.add(root);

        while(!nodeQueue.isEmpty()){
            int numChild = nodeQueue.size();
            var levelResult = new ArrayList<Integer>();
            while(numChild > 0){
                Node node = nodeQueue.poll();
                numChild--;

                levelResult.add(node.val);

                if(node.children == null) continue;
                for(var child: node.children){
                    nodeQueue.add(child);
                }

                
            }
            if(levelResult.size() > 0 ) levelOrder.add(levelResult);
        }
        return levelOrder;
    }
    
    public static void main(String[] args) {
        
        var child = new Node(2, Arrays.asList(new Node(5), new Node(6)));
        var root = new Node(1, Arrays.asList(child, new Node(3), new Node(4)));
        
        var  solution = new NAryTreeLevelTraversal();
        var result = solution.levelOrder(root);
        System.out.println(result);
    }
}