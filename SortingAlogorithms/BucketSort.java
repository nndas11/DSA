package SortingAlogorithms;


//  Bucket Sort is a sorting algorithm that works by distributing the elements into a number of buckets,
//  sorting each bucket individually (often with another algorithm like insertion sort),
//  and then combining the results.

//  Best for uniformly distributed data.
//  Usually used when input is in the range [0, 1) (but can be adapted for other ranges too).

//  ✅ Steps:
//  Create n empty buckets (lists).
//  Scatter: Put elements into buckets based on their value.
//  Sort each bucket individually.
//  Gather: Concatenate all sorted buckets.


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//  ?. sort an array of floating-point numbers between 0.0 and 1.0.
public class BucketSort {
    public static void main(String[] args) {
        float[] arr = {0.42f, 0.32f, 0.23f, 0.52f, 0.25f, 0.47f, 0.51f};
        System.out.println("Before sorting: " + Arrays.toString(arr));
        bucketSort(arr);
        System.out.println("After sorting: " + Arrays.toString(arr));
    }

    public static void bucketSort(float[] arr){
        int n = arr.length;
        if(n < 0)
            return;

//        1. Create n empty buckets
        List<Float>[] buckets = new List[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        // 2. Put array elements into different buckets
        for (float value : arr) {
            int index = (int)(value * n); // index in bucket
            buckets[index].add(value);
        }

        // 3. Sort individual buckets
        for (List<Float> bucket : buckets) {
            Collections.sort(bucket);
        }

        // 4. Concatenate all buckets into arr[]
        int index = 0;
        for (List<Float> bucket : buckets) {
            for (float value : bucket) {
                arr[index++] = value;
            }
        }
    }
}
