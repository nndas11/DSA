package Trees;

//  To find Top View of Binary Tree.
//  Refer: Vertical traversal video for better understanding.
//  It is basically the first node in each vertical line.
//  Map + Queue approach.
//  Map to store horizontal distance and node value.
//  Queue to do level order traversal while keeping track of horizontal distance.

import org.w3c.dom.Node;

import javax.swing.tree.TreeNode;
import java.util.*;

public class TopView {
    public static void main(String[] args) {
        // need sample tree and call topView function to test

    }

    private static List<Integer> topView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        // column , node value
        TreeMap<Integer, Integer> map = new TreeMap<>();
//        Node , col number
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();

        queue.add(new Pair<>(root, 0));

        while(!queue.isEmpty()){
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            int col = pair.getValue();

            if(!map.containsKey(col)){
                map.put(col, node.val);
            }

           if(node.left != null){
               queue.add(new Pair<>(node.left, col - 1));
           }

           if(node.right != null){
                queue.add(new Pair<>(node.right, col + 1));
           }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }


        return ans;
    }

    static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode (int item) {
            val = item;
            left = right = null;
        }
    }

    static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
