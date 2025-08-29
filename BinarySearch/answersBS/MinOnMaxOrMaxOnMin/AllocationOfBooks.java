package BinarySearch.answersBS.MinOnMaxOrMaxOnMin;


// Allocation of Books
// Problem Statement: You are given an array of integers arr where arr[i] represents the number of pages in the ith book.
// You are also given an integer m which represents the number of students.
// You need to allocate books to students such that each student gets at least one book and the maximum number of pages allocated to a student is minimized.
// Return the minimum possible value of the maximum number of pages allocated to a student.

//  Another variation which is almost same is Painter's Partition Problem.
//  Here we need to find the minimum time to paint all the boards.
//  The only difference is instead of pages we have time and instead of books we have boards
//  and instead of students we have painters.
//  The approach is same, only the variable names change.

public class AllocationOfBooks {
    public static void main(String[] args) {
        System.out.println(allocationOfBooks(new int[]{12,34,67,90}, 2));
    }

    public static int allocationOfBooks(int[] arr, int m){
        int l = 0;
        int r = 0;
        int ans = -1;

        for(int num: arr){
            r += num;
            l = Math.max(l , num);
        }

        while(l <= r){
            int mid = l + (r - l)/2;

            if(isPossible(arr, m , mid)){
                ans = mid;
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }

        return ans;
    }

    public static boolean isPossible(int[] arr, int m, int mid){
        int studentCount = 1;
        int pageSum = 0;

        for(int i=0;i<arr.length;i++){
            if(pageSum + arr[i] <= mid){
                pageSum +=  arr[i];
            }else{
                pageSum = arr[i];
                studentCount++;
//                if number of students exceed m or a single book has more pages than mid, return false
                if(studentCount > m || arr[i] > mid)
                    return false;
            }
        }
        return true;
    }
}
