package BinarySearch.answersBS.MinOnMaxOrMaxOnMin;

//  Another variation of binary search.
//  Here we are trying to minimize the maximum or maximize the minimum.
//  Eg:- Aggressive Cows, Painter's Partition Problem, Koko Eating Bananas
//  The idea is to find the search space and then apply binary search on it.
//  Then check for the mid-value, whether it is possible to do the task with this mid value or not.
//  If it is possible -> then we can try to minimize the maximum or maximize the minimum.
//  If it is not possible -> then we need to increase the minimum or maximum
//  So, if it is possible -> we move towards left -> r = m - 1
//  If it is not possible -> we move towards right -> l = m + 1
//  We need to find the maximum value in the array -> to find the search space.
//  We need to find the minimum value in the array -> to find the search space.
//  The minimum value can be 1 or 0 -> depends on the question.
//  The maximum value can be the maximum element in the array or sum of all elements in the array -> depends on the question.
//  So, the search space can be from min to max or 1 to max or 0 to max -> depends on the question.
//  The time complexity is O(n log m) -> n is the number of elements in the array and m is the search space.
//  The space complexity is O(1).
//  So, the overall time complexity is O(n log m) and space complexity is O(1).




public class Main {
}
