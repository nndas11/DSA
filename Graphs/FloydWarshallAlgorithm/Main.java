package Graphs.FloydWarshallAlgorithm;


//  Different from Dijkstra and Bellman-Ford algorithm -> where we find the shortest distance from source to all nodes.

//  If asked about this why this algorithm and what is the advantages.

//  We can run Dijkstra on every node as source node and find the shortest distance from every node to every other node.
//  Will take TC: v * E logv -> still less the Floyd-Warshall Algorithm. -> but won't work for negative cycle and edge
//  In Floyd-Warshall Algorithm -> Also known as Multi-Source Shortest Path Algorithm.
//      We find the shortest distance from every node to every other node.
//      Can also detect negative cycles.

//  Here we go via every node.

//  This is a Dynamic Programming Solution.
//  Because we will be in need of a precomputed solution.

//  We use Adjacency Matrix to store the graph -> in-place of edge we store the weight instead of 1.
//  The other values should be set to INF -> unreachable.
//  If undirected graph given -> change to directed with using same weight for both the directions.


//  ALGORITHM
    //1) Initialise dp(N x N) with Infinity.
    //2) Update dp[i][i] = 0;
    //3) Update given edge's weight in dp.
    //4) We need to find the minDistance from i to j via each node.
    //5) dp[i][j] = dp[i][via] + dp[via][j];
    //6) As a result, dp will have the min distance from any-to-any nodes of graph.

//  This algorithm is actually a brute force. No particular intuition behind it.

//  How to detect negative cycle?
//  If the cost[node][node] < 0 -> then negative cycle.
//  Because it should be 0.

//  TC: O(n3)

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        this is adjacency matrix -> -1 denotes no edge.
        int[][] adjacencyMatrix = {
                {0, 1, 43},
                {1, 0, 6},
                {-1, -1, 0}
        };
        System.out.println(Arrays.deepToString(floydWarshallAlgorithm(3, adjacencyMatrix)));
    }

    public static int[][] floydWarshallAlgorithm(int n, int[][] adjacencyMatrix){
//        Initialise dp(N x N) with Infinity.
        int[][] distance = new int[n][n];
        for(int[] row: distance)
            Arrays.fill(row, (int)1e9);

//        Update dp[i][i] = 0;
        for(int i=0;i<n;i++){
            distance[i][i] = 0;
        }

//        Update given edge's weight in dp. -> we can also use adjacencyMatrix as distance itself by making -1 as INF.
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(adjacencyMatrix[i][j] != -1)
                    distance[i][j] = adjacencyMatrix[i][j];
            }
        }

//        We need to find the minDistance from i to j via each node.
        for (int via=0;via<n;via++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
//                     dp[i][j] = dp[i][via] + dp[via][j];
                    distance[i][j] = Math.min(distance[i][j], distance[i][via] + distance[via][j]);
                }
            }
        }

//        NEGATIVE cycle check -> only if asked
        for(int i=0;i<n;i++){
            if(distance[i][i] < 0)
                return new int[][]{{-1}};
        }

//dp will have the min distance from any-to-any nodes of graph.
        return distance;
    }
}
