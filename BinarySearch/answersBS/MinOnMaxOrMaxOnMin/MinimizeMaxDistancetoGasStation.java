package BinarySearch.answersBS.MinOnMaxOrMaxOnMin;

//  TOO DIFFICULT TO UNDERSTAND

//  Gas Station
//  Problem Statement: You are given an array stations where stations[i] represents the position of
//  the ith gas station along a horizontal line. You are also given an integer k. You can add k
//  additional gas stations at any position along the line. Return the smallest possible value of the maximum distance
//  between adjacent gas stations after adding the k additional gas stations.
//  Answers within 10^-6 of the actual answer will be accepted. -> so this means give answer till 6 decimal places.

//  can be solved using binary search on the answer -> but this is still a new variation of the category.
//  or can be solved using max-heap


//  Here answer is double
//  so the normal BS like -> while(l <= r) or l = mid + 1 all ->  won't work
//  we need to do -> while(r - l > 1e-6) -> this means we are checking till 6 decimal places
//  and l = mid or r = mid -> this is because we are not sure whether mid is the answer or not
//  so we need to check for mid again and again till we reach the precision of 10^-6

import java.util.PriorityQueue;
import java.util.Queue;

public class MinimizeMaxDistancetoGasStation {
    public static void main(String[] args) {
        System.out.println(minmaxGasDist(new int[]{1,2,3,4,5,6,7,8,9,10}, 9));
    }

    public static double minmaxGasDist(int[] stations, int k) {
        int n = stations.length;
        double l = 0; // all gas station at the same point and we place all k stations there itself.
        double r = stations[n - 1] - stations[0]; // all gas stations are at extreme ends and we place all k stations in between them.
        double ans = -1;

        while((r - l) > 1e-6){
            double mid = l + (r -l)/2;
            if(isPossible(stations, k, mid)){
                ans = mid;
                r = mid;
            }else {
                l = mid;
            }
        }
        return  Math.round(ans * 1e6)/1e6;
    }


//    we check if we can place the stations such that the maximum distance between adjacent stations is less than or equal to mid
    private static boolean isPossible(int[] stations, int k, double mid) {
        int count = 0; // count of stations placed
        for(int i=0;i<stations.length - 1;i++){
            double distance = stations[i + 1] - stations[i];
            count += (int)(distance/mid); // number of stations that can be placed in this section
            if(count > k) // if we have already placed more than k stations, no need to check further
                return false;
        }
        return true;
    }


//    TC: (K * n)
    public static double bruteForce(int[] stations, int k){
        int n = stations.length;
        int[] howMany = new int[n - 1]; // keeps track of how many stations are placed in each section

//        going to place the k stations
        for(int i=0;i<k;i++){
            int maxIndex = -1;
            long maxSectionLength = -1;

//            here we are finding the section with maximum length -> this takes O(n) time
//            this is where we can optimise.
            for(int j=0;i<n-1;i++){
                long sectionLength = (stations[j + 1] - stations[j])/(howMany[j] + 1);
                if(sectionLength > maxSectionLength){
                    maxIndex = j;
                    maxSectionLength = sectionLength;
                }

            }

//            now we got the section with maximum length, place a station here
            howMany[maxIndex]++;
        }

//        now loop through find answer
        long ans = -1;
        for(int i=0;i<n-1;i++){
            long sectionLength = (stations[i + 1] - stations[i])/(howMany[i] + 1);
            ans = Math.max(ans, sectionLength);
        }
        return  ans;

    }

    private double usingHeap(int[] stations, int k){
        int n = stations.length;
        Queue<Pair> pq = new PriorityQueue<>();
        for(int i=0;i< n - 1;i++){
            pq.add(new Pair(stations[i + 1] - stations[i], i));
        }

        int[] howMany = new int[n - 1];

        for(int i=0;i<k;i++){
            Pair top = pq.poll();
            double sectionLength = top.sectionLength;
            int index = top.index;

            howMany[index]++;
            double newSectionLength = sectionLength/(howMany[index] + 1);
            pq.add(new Pair(newSectionLength, index));
        }

        return pq.peek().sectionLength;
    }

    public class Pair {
        double sectionLength;
        int index;

        Pair(double sectionLength, int index){
            this.sectionLength = sectionLength;
            this.index = index;
        }
    }
}
