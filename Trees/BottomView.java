package Trees;

import java.util.*;

// Same as Top View, but we keep on updating the value at every level.

public class BottomView {
    public static void main(String[] args) {

    }

    private static List<Integer> bottomView(TopView.TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        // column , node value
        TreeMap<Integer, Integer> map = new TreeMap<>();
//        Node , col number
        Queue<TopView.Pair<TopView.TreeNode, Integer>> queue = new LinkedList<>();

        queue.add(new TopView.Pair<>(root, 0));

        while(!queue.isEmpty()){
            TopView.Pair<TopView.TreeNode, Integer> pair = queue.poll();
            TopView.TreeNode node = pair.getKey();
            int col = pair.getValue();


            // for bottom view we update the value at every level
            map.put(col, node.val);


            if(node.left != null){
                queue.add(new TopView.Pair<>(node.left, col - 1));
            }

            if(node.right != null){
                queue.add(new TopView.Pair<>(node.right, col + 1));
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }


        return ans;
    }

    static class TreeNode {
        int val;
        TopView.TreeNode left, right;

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
