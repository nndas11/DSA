package Graphs;

public class MColoringProblem {
    public static void main(String[] args) {
        int[][] graph = {
                {1,2,3},
                {0,2},
                {0,1,3},
                {0,2}
        };
        int n = graph.length;
        int m = 3;

        System.out.println(mColoringProblem(graph, new int[n], 0, m, n));
    }

    public static boolean mColoringProblem(int[][] graph, int[] color, int node, int m, int n){

        if(node == n)
            return true;

        for(int i=1;i<=m;i++){
            if(isValid(graph, color, i, node)){
                color[node] = i;
                if(mColoringProblem(graph, color, node + 1, m, n))
                    return true;
                color[node] = 0;
            }
        }

        return false;
    }

    public static boolean isValid(int[][] graph, int[] color, int col, int node){
        for(int neighbour: graph[node]){
            if(color[neighbour] == col)
                return false;
        }
        return true;
    }
}
