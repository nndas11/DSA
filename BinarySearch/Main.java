package BinarySearch;

//  While doing Binary Search Problem -> all depends on sorting
//  Also the idea about Binary Search is that, we should be able to reduce our search space by half each time.
//  The array should be sorted fully or some portion should be sorted -> Queue to use Binary Search.
//  Like rotated or may be trying to find the breaking point.
//  Think of LOWER-BOUND and OUTER-BOUND -> many question can be solved using this.
//  Then we can compare the mid and mid - 1 or mid and mid + 1 element.
//  In some question we compare the mid with left and right and so on.

//  There are questions, where we find the pivot element and then do BS.
//  For finding pivot -> compare with right index only.


//  Basic Questions:
//  Search in Rotates Sorted Array: Finding the pivot element and do BS on the required area.
//  Find Peak Element:  Go to the area, where they can be a bigger element.


//  DIFFERENT PATTERNS AND VARIATIONS OF BINARY SEARCH:
//  Do Binary Search on the answer space -> eg:- Aggressive Cows, Koko Eating Bananas, Painter's Partition Problem.
//  Condition Based Binary Search -> eg:- Find the first True in a boolean array.
//  Finding the Breaking Point -> eg:- Find the first True in a boolean array.
//  Finding the Minimum or Maximum in a Rotated Sorted Array.
//  Finding the Lower-Bound and Upper-Bound -> eg:- Search Insert Position, Find First and Last Position of Element in Sorted Array.
//  Binary Search on 2D Array -> eg:- Median of Row-wise sorted matrix, Kth Smallest Element in a Sorted Matrix.
//  Cases when we start from the top right corner or bottom left corner of a 2D matrix and move in 2 directions-> eg:- Search a 2D Matrix II.
//  In 2d -> we do loop through the rows and do BS on each row -> eg:- Find the Median of Row-wise sorted matrix.
//  There also cases where we convert 2d to 1d and do BS -> eg:- Kth Smallest Element in a Sorted Matrix.
//  we do bs on rows and inside for loop.
//  converting 1d index to 2d index -> row = index / number_of_columns, column = index % number_of_columns.
//  Finding the Pivot element in a rotated sorted array -> eg:- Find Minimum in Rotated
//  BS on answers ->   while((r - l) > 1e-6) {  -> for precision questions. -> MinMax distance gas stations.
//  Max on min and Min on Max is BS

public class Main {
    public static void main(String[] args) {

    }
}
