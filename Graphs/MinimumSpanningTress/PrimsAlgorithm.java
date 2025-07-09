package Graphs.MinimumSpanningTress;

//  Prim's Algorithm is used to find the Minimum Spanning Tree.


//  Required:
//      PriorityQueue -> Min-Heap -> store (weight, node, parent)
//      Visited Array.

//  Here Priority Queue -> gives us the smallest one(weight here) -> which helps us in getting the minimum spanning tree.
//  Here, we are keeping node, parent -> this will help us to get the edge between them -> when needed to add them.

//  ALGORITHM:
    //  Add any node to PQ, (0, 0, -1).
    //  do while loop till PQ is empty.
    //  Pop elements from queue, is not visited
    //  mark it visited -> add edge to MinSpanningTree and edge weight to sum.
    //  Go through neighbours and push to PQ if unvisited.

//  INTUITION -> GREEDY APPROACH -> take the minimum edge with help of PQ.

//  If only the minimum spanning tree weight is required
//  then just need to store the weight and node in PQ, parent is not needed.

//  TC: ElogE + ElogE = ElogE
//  SC: V + E


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgorithm {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> primsAlgorithm(int n, ArrayList<ArrayList<ArrayList<Integer>>> adj){
        List<List<Integer>> minSpanningTree = new ArrayList<>();
        PriorityQueue<Tuple> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.weight, b.weight));
        boolean[] visited = new boolean[n];
        int sum = 0;

        minHeap.add(new Tuple(0, 0, -1));
//        O(e) -> run for all edges.
        while (!minHeap.isEmpty()){
//            log(h) -> worst case -> all edges will inside the PQ at a time.
            Tuple popped = minHeap.remove();
            int weight = popped.weight;
            int node = popped.node;
            int parent = popped.parent;

            if (visited[node])  continue;

            visited[node] = true;
            sum += weight;

//            adding to spanning tree.
            if(parent != -1){
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(node);
                temp.add(parent);
                minSpanningTree.add(temp);
            }

//            E loge -> log e is for push to PQ.
            for (int i=0;i<adj.get(node).size();i++){
                int adjNode = adj.get(node).get(i).get(0);
                int edgeWeight = adj.get(node).get(i).get(1);

                if(!visited[adjNode]){
                    minHeap.add(new Tuple(edgeWeight, adjNode, node));
                }
            }
        }

        return minSpanningTree;
    }

    public static class Tuple{
        int weight;
        int node;
        int parent;

        public Tuple(int weight, int node, int parent) {
            this.weight = weight;
            this.node = node;
            this.parent = parent;
        }
    }
}
