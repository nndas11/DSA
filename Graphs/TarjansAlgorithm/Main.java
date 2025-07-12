package Graphs.TarjansAlgorithm;

//  Tarjan's Algorithm
//  Refer Leetcode question -> Critical Connections in a Network --> Asked in AMAZON interview.

//  Bridges in a graph -> Bridge is an edge when removed, makes it broken down into two or more components.
//  To find the bridge -> Using Tarjan's Algorithm -> some changes to DFS algorithm.

//  DFS + time of insertion --> Concept used in many questions.

//  2 Arrays Required:
//      1.  time[] ->   DFS time insertion -> the time at which the node was reached while doing DFS.
//      2.  low[]  ->   minimum lowest time insertion of all adjacent nodes "apart from parent".

//  Even if visited -> we can update the low

//  if(low[adjNode] > time[node] -> then node - adjNode ---> bridge.

public class Main {
    public static void main(String[] args) {

    }
}
