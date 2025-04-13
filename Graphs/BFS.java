package Graphs;


//  Done using Queue data structure.


//  Time Complexity: O(V + E)
//  Space Complexity: O(V + E)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    static int V = 6; // number of vertices
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    // Add edge to undirected graph
    public static void addEdge(int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    public static void bfs(int node){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(node);
        visited[node] = true;

        while (!queue.isEmpty()){
            int n = queue.poll();
            System.out.println(n);

            for(int neighbour: graph.get(n)){
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    queue.add(neighbour);
                }
            }
        }
    }


    public static void main(String[] args) {
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[V];

        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(1, 3);
        addEdge(1, 4);
        addEdge(2, 5);

        bfs(0);
    }
}
