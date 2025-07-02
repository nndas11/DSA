package Graphs;

//  Dijkstra's Algorithm is used to find the shortest path possible.
//  We are given a source node, from that we need to find the shortest path possible to every node.
//  We will be dealing with weighted graph -> as this is the shortest path.
//  For weighted graph -> we will be representing them using pairs in adjacency list.
//  Since we are dealing with distance, we will have distance array -> which contains shortest distance to all nodes.


//  Dijkstra's Algorithm does not work for NEGATIVE WEIGHT CYCLE.
//  Won't work even when there is one negative edge or cycle with negative sum.
//  It will go around in cycle as in each traversal -> the distance will only reduce because of negative edges.
//  Thus fall in INFINITE LOOP.


//  Algorithm can be implemented in 2 ways:
//        1. Priority Queue.
//        2. Set -> the fastest way.
//        3. Queue also gives answer but TC will be large.


//  Using Priority Queue -> Min-Heap.
//  In Priority Queue -> we store -> {dist, node}.
//  So we will start from sourceNode where distance will be 0 -> push {0, sourceNode} to PQ.
//  Do till PQ is empty.
//  pop element and go through all its neighbours and if the current distance is less than given in Dist array
//  Update distance array -> only when updating push that to PQ.
//  At end, we will have the distance array with the shortest distance from source node to all nodes.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstrasAlgorithm {
    public static void main(String[] args) {
        List<List<Pair>> adj = Arrays.asList(
                new ArrayList<>(Arrays.asList(new Pair(1, 2), new Pair(2, 4))),  // node 0
                new ArrayList<>(Arrays.asList(new Pair(2, 1), new Pair(3, 7))),  // node 1
                new ArrayList<>(List.of(new Pair(4, 3))),                  // node 2
                new ArrayList<>(Arrays.asList(new Pair(4, 1))),                  // node 3
                new ArrayList<>()                                               // node 4
        );

        int[] distances = dijkstrasAlgorithm(5, 0, adj);
        System.out.println("Shortest distances from node " + 0 + ":");
        for (int i = 0; i < distances.length; i++) {
            System.out.println("To node " + i + " = " + distances[i]);
        }
    }

//    TC: E * log(V)
    public static int[] dijkstrasAlgorithm(int v, int source, List<List<Pair>> adj){
       int[] distance = new int[v];
        Arrays.fill(distance, (int) 1e9);

       PriorityQueue<PQPair> minHeap = new PriorityQueue<>((x, y) -> x.distance - y.distance);
       minHeap.add(new PQPair(source, 0));
       distance[source] = 0;

       while (!minHeap.isEmpty()){
           PQPair popped = minHeap.remove();
           int dist = popped.distance;
           int node = popped.node;

           for (Pair pair: adj.get(node)){
               int adjNode = pair.first;
               int edgeWeight = pair.second;

               if(dist + edgeWeight < distance[adjNode]){
                   distance[adjNode] = dist + edgeWeight;
                   minHeap.add(new PQPair(distance[adjNode], adjNode));
               }
           }
       }

        return distance;
    }

    public static class PQPair {
        int distance;
        int node;

        public PQPair(int distance, int node) {
            this.distance = distance;
            this.node = node;
        }
    }

    public static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
