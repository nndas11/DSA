package Graphs;


//  Color the graph with 2 colors such that no two adjacent nodes have the same color.

public class BipartiteGraph {
    public static void main(String[] args) {
        int[][] graph ={
                {1,2,3},
                {0,2},
                {0,1,3},
                {0,2}
        };

        System.out.println(bipartiteGraph(graph));
    }


    public static boolean bipartiteGraph(int[][] graph) {
        int n = graph.length;
        int[] visited = new int[n];

        for(int i=0;i<n;i++){
            if(visited[i] == 0){
                if(!dfs(i, 1, graph, visited))
                    return false;
            }
        }

        return true;
    }

    public static boolean dfs(int index, int color, int[][] graph, int[] visited){

        visited[index] = color;
        for(int neighbour: graph[index]) {
            if(visited[neighbour] == 0){
                if(!dfs(neighbour, -color, graph, visited))
                    return false;
            }else if(visited[neighbour] == color)
                return false;
        }

        return true;
    }
}
