package Trees;

import BinarySearch.answersBS.MinOnMaxOrMaxOnMin.MinimizeMaxDistancetoGasStation;

import java.util.*;

public class PrintRootToNodePath {
    public static void main(String[] args) {

    }

    private static List<Integer> path(TreeNode root, int target){
        List<Integer> ans = new ArrayList<>();
        if(findPath(root, target, ans)){
            return ans;
        }
        return new ArrayList<>();
    }

    private static boolean findPath(TreeNode root, int target, List<Integer> ans){
        if(root == null)
            return false;

        ans.add(root.val);
        if(root.val == target)
            return true;

        if(findPath(root.left, target, ans) || findPath(root.right, target, ans))
            return true;

        ans.remove(ans.size() - 1);

        return false;

    }

    // printing path using BFS -> where in Queue, we keep track of the path as well.
    // so in queue we store, the node, path(list of integer)
    // In while loop after pooing from queue, we check if node is target, if yes we return the path.
    // If outside the while loop -> then no path -> return empty    list.


    static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode (int item) {
            val = item;
            left = right = null;
        }
    }
}
