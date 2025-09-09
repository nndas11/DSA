package TwoPointerAndSlidingWindow;

//  Different Patterns of Two Pointer and Sliding Window:
//  1. Fixed Size Sliding Window.

//  2. Longest subarray or substring where condition -> most common asked in interviews. ->  Variable Size Sliding Window.
//        Expansion -> r and Contraction of window -> l.
//      1. Brute Force -> O(n^2) -> 2 for loops.
//      2. Optimal -> O(n + n) -> window sliding technique. -> r for expansion and l for contraction.
//      3. Most Optimal > O(n) -> only works for length not when we need to return the actual substring or subarray.
//              instead of using while inside -> we use if -> so that we don't traverse the arra y more than once.

//  3. Number of subarrays or substring with where condition.
//      Solved using pattern 2
//      Number of Substrings Containing All Three Characters -> check this problem.
//      Counting forwards and backwards -> check this problem.

//  4. Find shortest/minimum window with condition.

//  5. Two Pointer Technique (Opposite Directions).
//  6. Two Pointer Technique (Same Directions).


//  Popular Variations of Sliding Window and Two Pointer:
//  Used for finding the count.
//  exactly(goal)=atMost(goal)−atMost(goal−1) -> used to find the number of subarrays with sum k. -> only works for positive numbers.
//


public class Main {
}
