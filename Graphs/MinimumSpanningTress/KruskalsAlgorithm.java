package Graphs.MinimumSpanningTress;

//  It is based on Union-Find Concept.
//  Find the minimum spanning tree.

//  Algorithm:
//  Sort all edge according to weight.
//  Initially when we declare disjoin set, every node will parent to itself and single.
//  If not belonging to same component -> we add it to the spanning tree, which is our union-find.
//

import Graphs.DisjoinSetVERYIMPORTANT.DisjoinSet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KruskalsAlgorithm {
    public static void main(String[] args) {

    }

    public static int kruskalsAlgorithm(int V, List<List<List<Integer>>> adj){
//        First build the edges array -> sort based on weight
        List<Edge> edges = new ArrayList<>();

//        O(v+e)
        for (int i=0;i<V;i++){
            for(List<Integer> pair: adj.get(i)){
                int node = i;
                int adjNode = pair.get(0);
                int weight = pair.get(1);

                edges.add(new Edge(node, adjNode, weight));
            }
        }

//        e loge
        Collections.sort(edges);
        DisjoinSet disjoinSet = new DisjoinSet(V);
        int mstW = 0;
//        e * 4 * alpha
        for (Edge edge: edges){
            int u = edge.src;
            int v = edge.dest;
            int w = edge.weight;

            if(disjoinSet.findUParent(u) != disjoinSet.findUParent(v)){
                mstW += w;
                disjoinSet.unionBySize(u, v);
            }
        }

        return mstW;
    }

    static class Edge implements Comparable<Edge>{
        int src, dest, weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
}
