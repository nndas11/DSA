package SweepLineAlgorithm;

//  Sweep Line Algorithm
//  General Algorithm ->
//      1. Build events: typically (coordinate, delta) like +1 on start, -1 on end.
//      2. Sort events: by coordinate, breaking ties by delta (end before start).
//      3. Sweep line: iterate events, maintain a running count of active intervals.
//      4. Query results: use the running count to answer questions about overlaps, coverage, etc.
//  Applications ->
//  1. Finding the number of overlapping intervals at any point of time.
//  2. Finding the maximum number of overlapping intervals at any point of time.
//  3. Finding the total length covered by a set of intervals.
//  4. Finding the union of a set of intervals.
//  5. Finding the intersection of a set of intervals.
//  6. Finding the skyline of a set of buildings.
//  7. Finding the closest pair of points in a set of points.
//  8. Finding the convex hull of a set of points.
//  9. Finding the Voronoi diagram of a set of points.







//  Famously used to solve the problem of finding the number of overlapping intervals at any point of time.
//  Algorithm ->
//  1. Create an array of events -> start and end of intervals.
//  2. Sort the events based on time. If two events have same time, then end event should come before start event.
//  3. Traverse the events and maintain a count of overlapping intervals.
//  4. Update the maximum count of overlapping intervals.
//  5. The maximum count at any point of time is the answer.
//  Time Complexity -> O(n log n) -> for sorting the events.
//  Space Complexity -> O(n) -> for storing the events.




public class Main {
    public static void main(String[] args) {

    }
}
