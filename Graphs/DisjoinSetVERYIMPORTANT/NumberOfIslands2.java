package Graphs.DisjoinSetVERYIMPORTANT;

//  Disjoin Set with GRID.

//  This is Premium Locked Question in Leetcode.

//  This is an online query problem.
//  Where they give you a query -> you give me the answer.

//  Dynamic Graph + Connections -> Disjoin Set.

//  In GRID with Disjoint Set:
//  We represent each cell as a node in the Disjoint Set-> so we need a connection between the node number and cell(row, col)
//  (row, col) = row * m + col
//  n -> total number of rows.
//  m -> total number of cols.

//  Algorithm:
//  check the node is visited or not?
//  if visited -> return
//  if not visited
//  mark as visited and increase count
//  loop through 4 directions and look at adjacent node
//  if adjacent node is visited
//  check ultimate parent of adjacent node and current node
//  if diff ->  do union and reduce count
//  otherwise do nothing.

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslands2 {
    public static void main(String[] args) {
        int[][] operations = {
                {0, 0},
                {0, 0},
                {1, 1},
                {1, 0},
                {0, 1},
                {0, 3}
        };

        System.out.println(numberOfIsland(4, 5, operations));
    }

    public static List<Integer> numberOfIsland(int n, int m, int[][] operations){
        DisjoinSet disjoinSet = new DisjoinSet(n * m);
        boolean[][] visited = new boolean[n][m];
        int count = 0;

        int l = operations.length;
        List<Integer> ans = new ArrayList<>();

        int[][] directions = {
                {1, 0},
                {0, 1},
                {-1, 0},
                {0, -1}
        };

        for (int[] operation: operations){
            int row = operation[0];
            int col = operation[1];

            if(visited[row][col]){
                ans.add(count);
                continue;
            }
            count++;
            visited[row][col] = true;

            for (int[] direction: directions){
                int nr = row + direction[0];
                int nc = col + direction[1];

                if(isValid(nr, nc, n, m) && visited[nr][nc]){
                    int node = row * m + col;
                    int adjNode = nr * m + nc;
                    if(disjoinSet.findUParent(node) != disjoinSet.findUParent(adjNode)){
                        disjoinSet.unionBySize(node, adjNode);
                        count--;
                    }
                }
            }
            ans.add(count);

        }

        return ans;
    }

    public static boolean isValid(int r, int c, int n, int m){
        if(r < 0 || c < 0 || r >= n || c >=m)
            return false;
        return true;
    }
}
