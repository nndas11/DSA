package GreedyAlgorithm;

//  Asked in Companies.

//  We have just one meeting room.
//  Given the start and end time of each meeting.
//  Maximise the number of meeting we can have.

//  Even the solution is O(n) -> it doesn't mean we have to do in single loop, there can be multiple, we can do anything.
//  First thinking should be to solve this problem -> even if its brute force
//  So think about everything from prefix to graph to dp to trie, if stuck.

//  Hints for Meeting Problems:
//  Sort based on start or end or duration.
//  We have slots for each and fill up.
//  keep track of lastEnd or lastStart or maxEnd like this...

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NMeetingInOneRoom {
    public static void main(String[] args) {
        int[] start = {0, 3, 1, 5, 5, 8};
        int[] end = {5, 4, 2, 9, 7, 9};

        System.out.println("Most number of meetings: " + nMeetingInOneRoom(start, end));
    }

//    TC: O(nlogn) + O(n) + O(n)
//    Here we need to maximise the number of meetings -> we need to end meetings as fast as possible.
//    So we would need to sort by the end time in ascending order.
    public static int nMeetingInOneRoom(int[] start, int[] end){
        int n = start.length;
        List<Meeting> meetings = new ArrayList<>();
        for(int i=0;i<n;i++){
            meetings.add(new Meeting(start[i], end[i], i));
        }

        Collections.sort(meetings, (a, b) -> Integer.compare(a.end, b.end));
        int count = 0;
        int lastEnd = 0;
        for (Meeting meeting: meetings){
            int s = meeting.start;
            int e = meeting.end;
            int idx = meeting.idx;

            if(s > lastEnd){
                count++;
                lastEnd = e;
                System.out.println(idx);
            }
        }
        return count;
    }


//    if asked about the order -> we need to index to return it.
//    Otherwise, index not needed.

    static class Meeting {
        int start;
        int end;
        int idx;


        Meeting(int start, int end, int idx){
            this.start = start;
            this.end = end;
            this.idx = idx;

        }
    }
}
