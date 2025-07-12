package Graphs.KosarajusAlgorithm;

//  Kosaraju's Algorithm is used to find the Strongly Connected Components.
//  2 Questions asked in interview from this:
//      1. Find the number of strongly connected components.
//      2. Print the strongly connected components.

//  Only VALID FOR DIRECTED GRAPH.

//  What is a STRONGLY CONNECTED COMPONENT(SCC)?
//  A Strongly connected component is where every node in the component is reachable from every other node.
//  A single node can also be a strongly connected component.

//  Algorithm:
//  Sort All the edges according to finishing time. -> meaning do DFS and store all nodes in a Stack.
//  Reverse the edges. -> so now we can't go from one DFS to another. -> Reversing also known as transpose.
//  Do a DFS.

//   1. If we think let's say that our graph has n Strongly Connected Component, say sc1, sc2 ...scn. Then whole graph will be visited in order, `sc1-->sc2-->sc3-->....-->scn`.
//   2. Now if we remove all the edges which connect the 2 connected component then in one visit we will be traversing 1 Strongly Connected Component. `sc1, sc2, sc3,...,scn`.
//   3. So, Idea is to remove link between connected component. Ok! but how we know in advance exactly which edge is link? Ans is we don't. And that's why instead of removing edge, we will reverse all the edge. so a link edge b/w `sc1-->sc2` became `sc2-->sc1` and thus if you start with sc1, you will only visit sc1 component.
//   4. Does reversing edge will not affect component's like sc1,sc2 etc. Ans is no because they are Strongly Connected component, if you reverse each edge of a Strongly Connected Component, it will still be a Strongly Connected Component.
//   5. Ok! Alright, One final caveat, let's say we start traversing from sc2? Then in one visit we can traverse both sc1,sc2. To prevent this, we will sort the vertices in finish time of dfs and visit the vertices who finished last. So, if in original graph, there is a relation like `sc1-->sc2`, sc1 will always finish last and thus will be picked first.
//   6. Does BFS work? No, we have to sort according to finish time.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int n = 8;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)    adj.add(new ArrayList<>());
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(0);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(4).add(5);
        adj.get(4).add(7);
        adj.get(5).add(6);
        adj.get(6).add(4);
        adj.get(6).add(7);

        System.out.println(kosarajusAlgorithm(n, adj));
    }

    public static int kosarajusAlgorithm(int n, List<List<Integer>> adj){
        int count = 0;

//        Sort edges according to finishing time -> DFS + push element to Stack.
//        by this the first element -> will be on the top of stack -> so we know that belong to the first SCC.
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[n];
        for (int i=0;i<n;i++){ // -> for different components.
            if(!visited[i])
                dfs(i, adj, visited, stack);
        }

//        Reverse the graph -> Transpose.
        List<List<Integer>> adjTranspose = new ArrayList<>();
        for(int i=0;i<n;i++)    adjTranspose.add(new ArrayList<>());
        for(int i=0;i<n;i++){
            visited[i] = false; //-> for resuing visited array
            for (int adjNode: adj.get(i)){
//                i -> adjNode --> make it opposite
                adjTranspose.get(adjNode).add(i);
            }
        }


//        Do DFS by popping nodes from stack -> gives each component.
        while (!stack.isEmpty()){
            int node = stack.pop();
            if(!visited[node]){
                System.out.println( " Next Component");
                normalDfs(node, adjTranspose, visited);
                count++;
            }

        }

        return count;
    }

    public static void dfs(int node, List<List<Integer>> adj, boolean[] visited, Stack<Integer> stack){

        visited[node] = true;

        for(int adjNode: adj.get(node)){
            if(!visited[adjNode])
                dfs(adjNode, adj, visited, stack);
        }

        stack.push(node);
    }

    public static void normalDfs(int node, List<List<Integer>> adj, boolean[] visited){
        visited[node] = true;
        System.out.println(node);

        for (int adjNode: adj.get(node)){
            if(!visited[adjNode])
                normalDfs(adjNode, adj, visited);
        }
    }
}
