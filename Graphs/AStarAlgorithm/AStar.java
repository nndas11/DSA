package Graphs.AStarAlgorithm;


//  Similar to Dijkstra's Algorithm but with heuristics to guide the search more efficiently towards the goal.
//  Used in pathfinding and graph traversal, especially in games and AI applications.
//  It combines the benefits of Dijkstra's Algorithm and Greedy Best-First Search.
//  It uses a priority queue to explore nodes based on the cost to reach them and an estimated cost to the goal.
//  The heuristic function (often denoted as h(n)) estimates the cost from the current node to the goal.
//  The total cost function (often denoted as f(n)) is defined as:
//      f(n) = g(n) + h(n)
//  where g(n) is the cost to reach the current node from the start node.
//  The choice of heuristic is crucial for the performance of the A* algorithm. It should be admissible, meaning it never overestimates the true cost to reach the goal.
//  Common heuristics include the Manhattan distance, Euclidean distance, and Chebyshev distance, depending on the problem domain.
//  A* is optimal and complete when using an admissible heuristic, meaning it will always find the least-cost path if one exists.
//  It is widely used in various applications, including robotics, video games, and network routing.


// We should always choose h(n) <= actual cost to reach the goal from n. -> its always better to underestimate than overestimate.
// If h(n) = 0, A* behaves like Dijkstra's Algorithm.

public class AStar {
    public static void main(String[] args) {

    }

    private static int AStar(){
    return 0;
    }
}
