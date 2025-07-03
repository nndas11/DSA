package Graphs.DijkstrasAlgorithm;

//  Print the Shortest Path from 1 - n in an undirected weighted graph.
//  Source = 1
//  Destination = n

//  1 - indexed question.

//  HINT: Where Am I coming From.

//  We use parent array to keep track of where we are coming from.
//  Using parent[destination] -> we can backtrack the path and reverse it once you found it.


import java.util.*;

//  TC: O(E * logV) + O(n)

public class PrintShortestPath {
    public static void main(String[] args) {

    }

    public static List<Integer> printShortestPath(int n, int source, List<List<Pair>> adj){
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.first - b.first);
        int[] distance = new int[n + 1];
        int[] parent = new int[n + 1];

        Arrays.fill(distance, Integer.MAX_VALUE);
        for(int i=0;i<=n;i++){
            parent[i] = i;
        }

        distance[source] = 0;
        minHeap.add(new Pair(0, source));

        while (!minHeap.isEmpty()){
            Pair popped = minHeap.remove();
            int dist = popped.first;
            int node = popped.second;

            for (Pair it: adj.get(node)){
                int adjNode = it.first;
                int weight = it.second;

                if(dist + weight < distance[adjNode]){
                    distance[adjNode] = dist + weight;
                    minHeap.add(new Pair(distance[adjNode], adjNode));

                    parent[adjNode] = node;
                }
            }
        }

        List<Integer> path = new ArrayList<>();
//        if no path to destination -> n
        if (distance[n] == Integer.MAX_VALUE){
            path.add(-1);
            return path;
        }

        int node = n;
        while (parent[node] != node){
            path.add(node);
            node = parent[node];
        }

        path.add(source);
        Collections.reverse(path);
        return path;
    }

    public static class Pair{
        int first;
        int second;

        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
}
