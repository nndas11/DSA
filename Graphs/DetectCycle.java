package Graphs;


//  Detect cycle in a graph.
//  This is the course-schedule problem of leetcode.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycle {

    static public int v = 6;
    static public List<List<Integer>> adjacencyList = new ArrayList<>();

    public static void addEdgeDirected(int u, int v){
        adjacencyList.get(u).add(v);
    }

    public static void addEdge(int u, int v) {
        adjacencyList.get(u).add(v);
        adjacencyList.get(v).add(u);
    }
    public static void main(String[] args) {
        for (int i=0;i<v;i++){
            adjacencyList.add(new ArrayList<>());
        }

//        addEdge(1,2);
//        addEdge(1,3);
//        addEdge(2,3);

//        System.out.println(detectCycleUndirectedBFS(v, adjacencyList));
//        System.out.println(detectCycleUndirectedDFS(v, adjacencyList));

        addEdgeDirected(1,2);
        addEdgeDirected(2,3);
        addEdgeDirected(3,1);

        System.out.println(detectCycleDirectedDFS());

    }

//    We go different path from the starting node and reach the same node -> Cycle detected.
//    In queue, we store the node and the node from which we came from.
    public static boolean detectCycleUndirectedBFS(int v, List<List<Integer>> adjacencyList){
        boolean[] visited = new boolean[v];
//        This for loop is to check in each component of the graph.
        for(int i=0;i<v;i++){
            if(!visited[i]){
                if(checkCycleUndirectedBFS(i, v, adjacencyList, visited))
                    return true;
            }
        }

        return false;
    }

    private static boolean checkCycleUndirectedBFS(int src, int v, List<List<Integer>> adjacencyList, boolean[] visited){
        Queue<int[]> queue = new LinkedList<>();
        visited[src] = true;
        queue.add(new int[]{src, -1});

        while (!queue.isEmpty()){
            int[] pair = queue.remove();
            int node = pair[0];
            int parent = pair[1];

            for(int neighbour: adjacencyList.get(node)){
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    queue.add(new int[]{neighbour, node});
                }else if(neighbour != parent){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean detectCycleUndirectedDFS(int v, List<List<Integer>> adjacencyList){
        boolean[] visited = new boolean[v];
        for(int i=0;i<v;i++){
            if(!visited[i]){
                if(checkCycleUndirectedDFS(i, -1, adjacencyList, visited))
                    return true;
            }
        }
        return false;
    }

    private static boolean checkCycleUndirectedDFS(int src, int parent, List<List<Integer>> adjacencyList, boolean[] visited){
        visited[src] = true;
        for (int neighbour: adjacencyList.get(src)){
            if(!visited[neighbour]){
                if(checkCycleUndirectedDFS(neighbour, src, adjacencyList, visited))
                    return true;
            }else if(neighbour != parent){
                return true;
            }
        }
        return false;
    }


//    The Same algorithm for the undirected won't work for the directed graph
//    We have to visit the same node in the same path.
//    So simple way will be to use, visited and path visited array.

    public static boolean detectCycleDirectedDFS(){
        boolean[] visited = new boolean[v];
        boolean[] pathVisited = new boolean[v];

        for(int i=0;i<v;i++){
            if(!visited[i]){
                if(checkCycleDirectedDFS(i, visited, pathVisited))
                        return true;
            }
        }

        return false;
    }

    public static boolean checkCycleDirectedDFS(int src, boolean[] visited, boolean[] pathVisited){

        visited[src] = true;
        pathVisited[src] = true;

        for(int neighbour: adjacencyList.get(src)){
            if(!visited[neighbour]){
                if(checkCycleDirectedDFS(neighbour, visited, pathVisited))
                    return true;
            } else if(pathVisited[neighbour])
                return true;
        }

        pathVisited[src] = false;
        return false;
    }
}
