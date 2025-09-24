package SweepLineAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MeetingRoom2 {
    public static void main(String[] args) {
        System.out.println(minMeetingRooms(List.of(
                new int[]{0, 30},
                new int[]{5, 10},
                new int[]{15, 20}
        )));
    }

    public static int minMeetingRooms(List<int[]> intervals) {
        List<int[]> events = new ArrayList<>();
        int n = intervals.size();

        for(int[] interval: intervals){
            int start = interval[0];
            int end = interval[1];

            events.add(new int[]{start, +1});
            events.add(new int[]{end, -1});
        }

        Collections.sort(events, (a, b) -> {
            if(a[0] == b[0])  return (a[1] - b[1]);
            return a[0] - b[0];
        });

        int maxDays = 0;
        int days = 0;

        for(int[] event: events){
            days += event[1];
            maxDays = Math.max(maxDays, days);
        }

        return maxDays;
    }
}
