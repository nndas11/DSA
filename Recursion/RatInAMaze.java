package Recursion;

import java.util.ArrayList;
import java.util.List;

//  testing
public class RatInAMaze {

    public static int[] xDir = {1, 0, -1, 0};
    public static int[] yDir = {0, 1, 0, -1};
    public static char[] dir = {'D', 'R', 'U', 'L'};

//    if you need answer in lexicographical order, then traverse -> D L R U

    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };

        ratInMaze(result, new StringBuilder(), maze, 0, 0);

        System.out.println("ALL POSSIBLE PATHS ARE: " + result);
    }

    public static void ratInMaze(List<String> result, StringBuilder path, int[][] maze, int r, int c){

        if(r < 0 || c < 0 || r >= maze.length || c >= maze[0].length || maze[r][c] == 0)
            return;

        if(r == maze.length - 1 && c == maze[0].length - 1){
            result.add((path.toString()));
            return;
        }

//        maze[r][c] = 0; // MARK IT VISITED -> BY BLOCKING

        for(int i=0;i<4;i++){
            int rc = xDir[i];
            int cc = yDir[i];
            char d = dir[i];

            maze[r][c] = 0;
            path.append(d);
            ratInMaze(result, path, maze, r + rc, c + cc);
            path.deleteCharAt(path.length() - 1);
            maze[r][c] = 1;
        }

//        maze[r][c] = 1; // MARK AS UNVISITED
    }


}
