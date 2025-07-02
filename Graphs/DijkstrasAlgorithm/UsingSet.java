package Graphs.DijkstrasAlgorithm;

//  Set
//      - Set stores unique values.
//      - Also store in ascending order.

//  Use SET to erase already existing path.
//  Improves TC slightly -> removes is log(n).

//  HashSet in Java does not guarantee any order at all.
//  Java does not store elements in ascending order

//  TreeSet Overview
//  Stores unique elements in sorted (ascending) order by default.
//
//  Backed by a Red-Black Tree, like std::set in C++.
//
//  Offers logarithmic time for add(), remove(), and contains() operations.

//  So we were using PQ -> min-heap -> as we needed smallest element possible
//  But this also possible with Set data structure -> In set we store {dist, node}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class UsingSet {
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

    public static int[] dijkstrasAlgorithm(int v, int source, List<List<Pair>> adj){
        int[] distance = new int[v];
        Arrays.fill(distance, (int)1e9);

        TreeSet<PQPair> set = new TreeSet<>((a, b) -> a.distance - b.distance);
        set.add(new PQPair(0, source));
        distance[source] = 0;

        while (!set.isEmpty()){
            PQPair popped = set.pollFirst();
            int dist = popped.distance;
            int node = popped.node;

            for (Pair pair: adj.get(node)){
                int edgeWeight = pair.second;
                int adjNode = pair.first;

                if(dist + edgeWeight < distance[adjNode]){

//                    erase if exists
                    if(distance[adjNode] != (int) 1e9){
                        set.remove(new PQPair(distance[adjNode], adjNode));
                    }

                    distance[adjNode] = dist + edgeWeight;
                    set.add(new PQPair(distance[adjNode], adjNode));
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
