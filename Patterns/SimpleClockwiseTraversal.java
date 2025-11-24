package Patterns;

import java.util.*;

public class SimpleClockwiseTraversal {

    // Extract all nodes in clockwise direction (simple, iterative)
    public static List<Integer> extractClockwise(Map<Integer, List<Integer>> graph, int start) {
        List<Integer> result = new ArrayList<>();

        int prev = -1;               // no previous node at the start
        int current = start;         // start from this node
        result.add(current);         // add start node

        while (true) {
            List<Integer> neighbours = graph.get(current);
            int next = -1;

            // pick the neighbour that is not the previous one
            for (int n : neighbours) {
                if (n != prev) {
                    next = n;
                    break;
                }
            }

            // move one step forward
            prev = current;
            current = next;

            // if we've come back to start, stop
            if (current == start || current == -1) break;

            result.add(current);
        }

        return result;
    }

    public static void main(String[] args) {
        // build adjacency list for circular graph 1–2–3–4–1
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(2, 4));
        graph.put(2, Arrays.asList(1, 3));
        graph.put(3, Arrays.asList(2, 4));
        graph.put(4, Arrays.asList(3, 1));

        // run clockwise traversal
        List<Integer> order = extractClockwise(graph, 1);
        System.out.println("Clockwise order: " + order);
    }
}

