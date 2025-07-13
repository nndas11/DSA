package Graphs.Eulerian;

//  Every Edge visited only once -> Hierholzers Algorithm

//   Reconstruct Itinerary -> REFER THIS QUESTION.

//  Hierholzers Algorithm is a graph algorithm used to find an Eulerian Path or Eulerian Circuit —
//  a path/cycle that visits every edge exactly once in a graph.

//  Eulerian Circuit: A cycle that uses every edge exactly once and ends at the starting vertex.
//  Eulerian Path: A path that uses every edge exactly once but may start and end at different vertices

//  Algorithm:
//  1.  Start at a vertex with unused edges.
//  2.  Greedily go deep following edges, removing them as you go.
//  3.  If you reach a node with no outgoing edges left, add it to the final path.
//  4.  Backtrack and continue from vertices that still have unused edges.
//  5.  Since you add nodes after finishing all their paths, the result is in reverse order → You reverse it at the end.

public class HierholzersAlgorithm {
}
