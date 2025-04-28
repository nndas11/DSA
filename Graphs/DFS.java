package Graphs;

//  Trees and LinkedList all are sub-graphs of graph.
//  Trees are connected acyclic graphs.
//  If a tree has N vertexes, then it have N - 1 edges.

//  3 Ways to represent graph:
//  1. Edge List.
//  2. Adjacency Matrix(There is will loss of space).
//  3. Adjacency List(Mostly Used and Best Way).

//  Adjacency List can be represented as HashMap with ArrayList as value.
//  Or can also be represented as 2d arrayList if the nodes values as 0,1,2 etc.. as they can be used as the index.
//  Visited can be SET or ARRAYLIST of boolean.


//  DFS can be done using recursion and also iteratively using stack.
//  In DFS also we can create directions array and loop through that and call the recursion.

//  Time Complexity:   O(V + E)
//  Space Complexity:  O(V + E)

import java.util.*;

public class DFS {
    static int V = 6; // number of vertices
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    // Add edge to undirected graph
    public static void addEdge(int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }


    public static void dfsWithRecursion(int node){
        visited[node] = true;
        System.out.println(node);

        for( int neighbor : graph.get(node)){
            if(!visited[neighbor])
                dfsWithRecursion(neighbor);
        }

    }

    public static void dfsWithStack(int node){
        Stack<Integer> stack = new Stack<>();
        stack.push(node);
        visited[node] = true;

        while (!stack.isEmpty()){
            int n = stack.pop();
            System.out.println(n);
            for (int neighbor: graph.get(n)){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    stack.push(neighbor);
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

//        dfsWithRecursion(0);
        dfsWithStack(0);
    }
}
