package Graphs.DijkstrasAlgorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//  PQ not needed as the value is increasing level by level -> so simple BFS -> so queue only needed.

//  A question which we can visualize as a Tree problem, most probably would be able to solve using Graph as Tree is a part of Graph.


public class MinimumMultiplicationstoReachEnd {
    public static void main(String[] args) {
        System.out.println(helper(new int[]{2, 5, 7}, 3, 30));
    }

    public static int helper(int[] arr, int start, int end){
        Queue<Pair> queue = new LinkedList<>();
//        nodes can be any number from 0 to 100000 as we're doing modulo 100000.
        int[] distance = new int[100000];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        queue.add(new Pair(start, 0));

        while (!queue.isEmpty()){
            Pair popped = queue.remove();
            int node = popped.first;
            int steps = popped.second;

            if(node == end)
                return steps;

            for (int i=0;i<arr.length;i++){
                int newNode = (node * arr[i]) % 100000;
                if(steps + 1 < distance[newNode]){
                    distance[newNode] = steps + 1;
                    queue.add(new Pair(newNode, distance[newNode]));
                }
            }
        }

        return -1;
    }

    public static class Pair {
        int first, second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
