package Graphs;


//  Famous for rotting oranges question.

import java.util.LinkedList;
import java.util.Queue;

public class MultiSourceBFS {
    public static void main(String[] args) {
        int[][] grid = {
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };
        System.out.println(rottingOranges(grid));
    }

    public static int rottingOranges(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int minutes = 0;
        int fresh = 0;

        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2)
                    queue.add(new int[]{i, j});
                if(grid[i][j] == 1)
                    fresh++;
            }
        }

        int[][] directions = {
                {1, 0},
                {0, 1},
                {-1, 0},
                {0, -1}
        };

        while(!queue.isEmpty() && fresh > 0){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int[] pos = queue.poll();
                for(int[] dir: directions){
                    int x = pos[0] + dir[0];
                    int y = pos[1] + dir[1];

                    if(x < 0 || y < 0 || x >= m || y >= n || grid[x][y] != 1)
                        continue;

                    grid[x][y] = 2;
                    queue.add(new int[]{x, y});
                    fresh--;
                }
            }
            minutes++;
        }

        return fresh > 0 ? -1 : minutes;
    }
}
