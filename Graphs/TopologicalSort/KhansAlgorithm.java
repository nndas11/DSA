package Graphs.TopologicalSort;

//  Topological Sorting using BFS is known as Khans Algorithm.
//  Kahn's algorithm is based on indegree of nodes:
//
//  Indegree of a node = number of incoming edges.

//  STEPS:
//      1. Insert all nodes with in-degree 0.
//      2. Pop each one out, and print them for our topological sorting.
//      3. Go through its neighbours and decrease their in-degree by one.
//      4. if those in-degree has reached 0, push them to the queue.

import java.util.*;

public class KhansAlgorithm {

    static int v = 6;
    static List<List<Integer>> adjacencyList = new ArrayList<>();

    public static void main(String[] args) {

        for (int i = 0; i < v; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        adjacencyList.get(2).add(3);
        adjacencyList.get(3).add(1);
        adjacencyList.get(4).add(0);
        adjacencyList.get(4).add(1);
        adjacencyList.get(5).add(0);
        adjacencyList.get(5).add(2);

        System.out.println("Topological sorting of the graph is: " + khansAlgorithm(v, adjacencyList));
    }

    public static List<Integer> khansAlgorithm(int v, List<List<Integer>> adj){
        Queue<Integer> queue = new LinkedList<>();
        int[] inDegree = new int[v];
        List<Integer> ans = new ArrayList<>();

//        Find all in-degree
        for (int i=0;i<v;i++){
            for (int node: adj.get(i)){
                inDegree[node]++;
            }
        }

//        Insert all nodes with in-degree 0.
        for (int i=0;i<v;i++){
            if (inDegree[i] == 0)
                queue.add(i);
        }

        while (!queue.isEmpty()){
//             Pop each one out, and print them for our topological sorting.
            int node = queue.remove();
            ans.add(node);

//            Go through its neighbours and decrease their in-degree by one.
            for(int child: adj.get(node)){
                inDegree[child]--;
//                if those in-degree has reached 0, push them to the queue.
                if(inDegree[child] == 0)
                    queue.add(child);
            }
        }

        return ans;
    }
}
