package DynamicProgramming;

//  https://leetcode.com/discuss/post/662866/dp-for-beginners-problems-patterns-sampl-atdb/

//  Overlapping sub-problems -> then we store the values of sub-problems in map/ table.
//  So we check the value is already present and uses that instead of recalculating.

//  Converting recursion to DP
//  1. Creating thr DP array or hashMap -> depends on the maximum number of sub-problems.
//  2. store the value which is computed.
//  3. Check if the value is present before competing again.

// 2 methods:
//      1. Tabulation -> bottom-up -> we will go from base case to required case. we fill the base-cases we find in recursion here.
//      2. Memoization -> top-down -> recursion like


//  How can we identify this is a DP problem:
//  First understand and figure out this is a recursion problem.
//  1.  count the no of ways.
//  2.  multiple ways of doing this -> what is the minimum or maximum.


//  SHORTCUT:
//  1.  Try to represent the problem in terms of index.
//  2.  Do all possible stuff on the index according to the problem statement.
//  3.  count all the ways -> sum of all stuff.
//      find min       -> min of all stuff.
//      find max       -> max of all stuff.

public class Main {
    public static void main(String[] args) {

    }


}
