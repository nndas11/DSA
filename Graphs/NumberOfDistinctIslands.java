package Graphs;

//Given a boolean 2D matrix grid of size n * m. You have to find the number of distinct islands where a group of connected 1s (horizontally or vertically) forms an island. Two islands are considered to be distinct if and only if one island is not equal to another (not rotated or reflected).

//  When we think Distinct -> we go for HashSet -> correct thinking is that.
//  Now how can we store these indexes, just storing won't work as they are different.
//  Another thinking will be to store the sides, but won't work like cases of hollow and all.
//  So the answer is to store all indexes itself, but before storing we find diff with the base node( node from where the BFS or DFS starts) and store those
//  Also in JAVA, we need to store them as string for the hashmap to work

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class NumberOfDistinctIslands {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}
        };

        System.out.println(numberOfDistinctIsland(grid));
    }



    public static int numberOfDistinctIsland(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

//        HashSet<List<int[]>> distinctIslands = new HashSet<>(); -> THIS WON'T WORK -> We need to convert it to String.
        HashSet<ArrayList<String>> distinctIslands = new HashSet<>();


        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    ArrayList<String> island = new ArrayList<>();
                    dfs(i, j, i, j, island, grid, visited);
                    distinctIslands.add(island);
                }
            }
        }

        return distinctIslands.size();
    }

    public static void dfs(int br, int bc, int r, int c, ArrayList<String> island, int[][] grid, boolean[][] visited){

        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || visited[r][c] || grid[r][c] == 0)
            return;

        visited[r][c] = true;

        island.add( toString(r - br,c - bc));

        dfs(br, bc, r + 1, c, island, grid, visited);
        dfs(br, bc, r - 1, c, island, grid, visited);
        dfs(br, bc, r , c + 1, island, grid, visited);
        dfs(br, bc, r , c - 1, island, grid, visited);
    }

    public static String toString(int r, int c){
        return Integer.toString(r) + Integer.toString(c);
    }
}
