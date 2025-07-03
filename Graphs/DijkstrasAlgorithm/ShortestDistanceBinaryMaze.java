package Graphs.DijkstrasAlgorithm;


//  We can't use DP for these problems
//      as we are moving in 4 directions, and we need to keep track of visited array.

//  Grid questions with 2 directions can be solved using DP as visited array is not needed as we won't be visiting them again.

//  Shortest path/ distance -> Dijkstra's algorithm.
//  Since Grid/ Maze -> everything becomes 2-dimensional.
//  Distance is 2-D and in PQ -> we store {distance, row, col}.

//  Here the distance of moving from cell to cell is always 1.
//  so the distance will always be sorted in the PQ.
//  So instead of PQ -> we can simply use queue and save logarithmic time complexity.

//  So we can do Dijkstra with queue data structure.
//  So we're doing basically using BFS, can be done using DFS in the other way also.

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceBinaryMaze {
    public static void main(String[] args) {
        int[][] grid = {
                {1 ,1 ,1 ,1},
                {1, 1, 0, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0},
                {1, 0, 0, 0}
        };

        System.out.println(shortestDistanceBinaryMaze(grid, new int[]{0, 1}, new int[]{2, 2}));
    }

    public static int shortestDistanceBinaryMaze(int[][] grid, int[] source, int[] destination){

        int[][] directions = {
                {1, 0},
                {0, 1},
                {-1, 0},
                {0, -1}
        };

        int n = grid.length;
        int m = grid[0].length;

        Queue<Tuple> queue = new LinkedList<>();
        int[][] distance = new int[n][m];
        for(int[] row: distance){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        distance[source[0]][source[1]] = 0;
        queue.add(new Tuple(0, source[0], source[1]));

        while (!queue.isEmpty()){
            Tuple popped = queue.remove();
            int dist = popped.first;
            int row = popped.second;
            int col = popped.third;

            if(row == destination[0] && col == destination[1])
                return dist;

            for (int[] dir: directions){
                int nr = row + dir[0];
                int nc = col + dir[1];

                if(nr < 0 || nc < 0 || nc >= n || nc >= m || grid[nr][nc] == 0)
                    continue;

                if(dist + 1 < distance[nr][nc]){
                    distance[nr][nc] = dist + 1;
                    queue.add(new Tuple(distance[nr][nc], nr, nc));
                }

            }
        }



        return -1;
    }

    public static class Tuple {
        int first;
        int second;
        int third;

        public Tuple(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }

}
