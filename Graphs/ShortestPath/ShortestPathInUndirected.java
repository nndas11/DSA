package Graphs.ShortestPath;


//  Finding the shorted path in a undirected graph with unit weights(1).

//  Solution
//  Solved Using BFS algorithm.
//  Solved using queue data structure -> will be storing the node and distance.
//  Need a distance array -> as we are dealing with finding the shortest path.
//  Push the source node with distance 0 into the queue.
//  Now, do the loop till the queue is empty.
//      pop the element
//      goto its edges
//      calculate the distance.
//      if less update the distance array.
//      if distance array updated -> push that node and distance into the queue.


//  TC: O(v + e).

import java.util.*;

public class ShortestPathInUndirected {
    public static void main(String[] args) {
        int[][] edges = {
                {0, 1},
                {0, 3},
                {1, 2},
                {3, 4},
                {4, 5},
                {5, 6},
                {2, 6},
                {7, 8},
                {6, 8},
                {6, 7}
        };
        System.out.println("Minimum distance from the source node is: " + Arrays.toString(shortestPath(0, 9, edges)));
    }

    public static int[] shortestPath(int sourceNode, int n, int[][] edges){
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for (int i=0;i< edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }


        Queue<Integer> queue = new LinkedList<>();
        queue.add(sourceNode);
        dist[sourceNode] = 0;

        while (!queue.isEmpty()){
            int node = queue.remove();

            for (int it: adj.get(node)){
                if(dist[node] + 1 < dist[it]){
                    dist[it] = dist[node] + 1;
                    queue.add(it);
                }
            }
        }

        for (int i=0;i<n;i++){
            if(dist[i] == Integer.MAX_VALUE)
                dist[i] = -1;
        }

        return dist;
    }
}
