package Graphs.TopologicalSort;


//  Topological sort is a linear ordering of vertices
//  in a Directed Acyclic Graph (DAG) such that for every directed edge u -> v, vertex u comes before v in the ordering.

//  Topological sort can only be done in DAG -> so we can apply it in a directed graph to check for cycle detection
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {

    static int v = 6;
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    public static void main(String[] args) {
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);

        System.out.println(topologicalSortUsingDFS(adj, v));

    }

    static public List<Integer> topologicalSortUsingDFS(ArrayList<ArrayList<Integer>> adj, int v){
        boolean[] visited = new boolean[v];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<v;i++){
            if(!visited[i])
                dfs(i, adj, visited, stack);
        }



        List<Integer> ans = new ArrayList<>();
        while(!stack.isEmpty()){
            ans.add(stack.pop());
        }
        return  ans;
    }

    static public void dfs(int i, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> stack){
        visited[i] = true;
        for(int it: adj.get(i)){
            if(!visited[it])
                dfs(it, adj, visited, stack);
        }
        stack.push(i);
    }
}
