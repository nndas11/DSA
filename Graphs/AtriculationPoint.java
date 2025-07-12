package Graphs;

//  REWATCH THE LAST TWO VIDEOS OF THE STRIVER GRAPH PLAYLIST.

//  Articulation Points -> Nodes on whose removal, the graph break into multiple components.
//  Pre-requisite -> bridge in a graph.

//  time -> store the time of reaching node during DFS --> Same as bridges.
//  low ->  minimum of all adjacent nodes apart from parent and visited node --> Slight change from bridges -> the last part.

//  if(low[adjNode] > time[node] -> then node - adjNode ---> bridge.

//  if the adjacent node is not parent and visited -> we take time not low. But why?
//  here that node can be removed so via the low many not be possible, so we take the low.
//  in bridge we took low

//  so if the entry point of the node and minium entry point of the adjacent is same -> then they are reaching through same
//  so then adjacent will only be reaching thorough node -> so it becomes an articulation point.

//  starting point and multiple children -> starting point becomes articulation point.
//  connecting node in the middle -> it becomes articulation point.


//          0
//        -   -
//      1  - -   2

// in this case 0, has 2 adjacent node, but it cannot be an articulation point.
//  this is the reason why child++ is inside the non-visited if statement.

import java.util.ArrayList;
import java.util.List;

public class AtriculationPoint {
    private static int timer = 1;

    public static void main(String[] args) {

    }

    public static List<Integer> articulationPoints(int n, List<List<Integer>> adj){
        List<Integer> ans = new ArrayList<>();

//        DFS
        boolean[] visited = new boolean[n];
        int[] time = new int[n];
        int[] low = new int[n];

        int[] mark = new int[n]; // -> Marks whether the node is an articulation point. doing this because the same node can be added multiple time. // can use set directly

        for(int i=0;i<n;i++){
            if(!visited[i])
                dfs(i, -1, adj, visited, time, low, mark);
        }

        for(int i=0;i<n;i++){
            if(mark[i] == 1)
                ans.add(i);
        }

        if(ans.isEmpty())
            ans.add(-1);

        return ans;
    }

    private static void dfs(int node, int parent, List<List<Integer>> adj, boolean[] visited, int[] time, int[] low, int[] mark){
        visited[node] = true;

        time[node] = low[node] = timer;
        timer++;

        int child = 0; // -> for the starting node -> to check whether it is an articulation point.

        for (int adjNode: adj.get(node)){
            if(adjNode == parent)   continue;

            if(!visited[adjNode]){
                dfs(adjNode, node, adj, visited, time, low, mark);

                low[node] = Math.min(low[node], low[adjNode]);

                if(time[node] <= low[adjNode] && parent != -1)
                    mark[node] = 1;

                child++;
            }else {
                low[node] = Math.min(low[node], time[adjNode]);
            }

            if (child > 1 && parent == -1)
                mark[node] = 1;
        }
    }
}
