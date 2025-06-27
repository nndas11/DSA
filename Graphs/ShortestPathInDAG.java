package Graphs;

//  For graphs with weighted edges -> represent them as List of Pairs.

//  Step 1: Do a topological sort using BFS or DFS.
//  Step 2: Take out the nodes from Stack and "relax the edges".
//      - Relax the edges -> Important concept from now onwards.
//      - Define a distance array with infinity. -> this will give us the distance from the source to the node.
//      - So starting from source node -> its distance will be 0, so make dist[src] = 0;
//      - pop nodes from stack till empty
//      - go through the edges and find the distance between them and update the distance array with min value.
//  Step 3: Now we got the answer.

//  We will study diff algorithm in future to calculate the shortest distance.
//  Topo sort method can be used only for DAG.
//  For graph with cycle -> we need to use Dijkstra algorithm.

import java.util.*;

//  TC: O(v + e) + O(v + e).

public class ShortestPathInDAG {
    public static void main(String[] args) {
        int[][] edges = {
                {0, 1, 2},
                {0, 4, 1},
                {4, 5, 4},
                {4, 2, 2},
                {1, 2, 3},
                {2, 3, 6},
                {5, 3, 1}
        };
        System.out.println("Shorted Path from 0 to each node is: " + Arrays.toString(shortestPath(6, 0, 7, edges)));
    }

//    m -> no of edges
//    edges -> 2-D array, contains 3 values in each index -> u, v, w. so edge is from u to v with weight w.
    public static int[] shortestPath(int n, int sourceNode, int m, int[][] edges){
        int[] dist = new int[n];


        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Pair>());
        }

        for (int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            adj.get(u).add(new Pair(v, w));
        }

//        Finding the topo sort
        int[] visited = new int[n];
        Stack<Integer> stack = new Stack<>();
//        Optimisation -> Instead of doing topo sort for each component.
//        We can just do for the source node only.
//        As nodes which are not part of the component of the source node will be unreachable -> will have distance -1.
        for(int i=0;i<n;i++){
            if(visited[i] == 0)
                topologicalSort(i, adj, stack, visited);
        }

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[sourceNode] = 0;
        while (!stack.isEmpty()){
            int node = stack.pop();



//            we can remove this check -> will also work
            if(dist[node] != Integer.MAX_VALUE){
                for(Pair pair: adj.get(node)){
                    int v = pair.first;
                    int w = pair.second;

                    dist[v] = Math.min(dist[v], dist[node] + w);
                }
            }
        }

//        if not reaching the node, then currently we return the MAX_VALUE
//        better to return -1, there
//        2 ways to do this, declare the distance array with -1, then add a check to see if the value is -1, then assign the dis + w and otherwise min.
//        or change it after wards looping through

        return dist;
    }

    public static void topologicalSort(int node, List<List<Pair>> adj, Stack<Integer> stack, int[] visited){
        visited[node] = 1;

        for(Pair pair: adj.get(node)){
            int u = pair.first;
            if(visited[u] == 0)
                topologicalSort(u, adj, stack, visited);
        }

        stack.push(node);
    }

    public static class Pair{
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }


    }
}
