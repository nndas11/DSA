package Graphs.BellmanFordAlgorithm;

//  Also used to find the shorted distance from source to all destination.
//  This can also be used for NEGATIVE edge or negative cycle(path weight < 0) -> Main advantage from Dijkstra's Algorithm.
//  Only work for directed graph
//  If given undirected graph, convert to directed graph by using the same edge length for both direction.

//  ALGORITHM:
//  1.  Relax all edges (n- 1) times sequentially.
//      Relaxation requires a distance array with dist[source] = 0 and all others set to INF.
//      Relaxation oef edges means
//          if(dist[u] + wt < dist[v]) -> dist[v] = dist[u] + wt;
//  2.  1 iteration means going through all the edges once -> edges can be in any order.
//      if the dist[node] == INF -> then skip it in that iteration.


//  Why (n - 1) iterations? -> Because it worst case, the source edge can be in the bottom of edges arrays and it requires n - 1 iteration to find shortest distance for each.
//  How to detect negative cycle? -> no matter how many edges in the graph all will be updated for sure

//  Generally asked in follow-up to Dijkstra algorithm.

// O(V * E)
//  O(v)

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] edges = {
                {3, 2, 6},
                {5, 3, 1},
                {0, 1, 5},
                {1, 5, -3},
                {1, 2, -2},
                {3, 4, -2},
                {2, 4, 3}
        };
        System.out.println(Arrays.toString(bellManFordAlgorithm(edges, 6, 0)));
    }

    public static int[] bellManFordAlgorithm(int[][] edges, int n, int source){
        int[] distance = new int[n];
        Arrays.fill(distance, (int)1e9);

        distance[source] = 0;

        for (int i=0;i<n- 1;i++){
//            this is extra optimisation -> for Early termination -> if in an iteration no node is updated -> then we have found the answer
            boolean updated = false;
            for (int[] edge: edges){
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];

                if(distance[u] != (int)1e9 && distance[u] + w < distance[v]){
                    distance[v] = distance[u] + w;
                    updated = true;
                }

            }
            if(!updated)
                break;
        }

//        this is also extra code -> used to check the negative cycle.
//        if doing this we can't use the boolean updated variable.
//        because the nth relaxation is used to check for the negative cycle.
            for (int[] edge: edges){
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];

//                in the Nth relaxation also the distance is array is getting updated -> then negative cycle
//                return -1
                if(distance[u] != (int)1e9 && distance[u] + w < distance[v]){
                    return new int[]{-1};
                }

        }

        return distance;
    }


}
