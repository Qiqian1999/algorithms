import java.util.*;

public class Interval {
    /* 57. Insert Interval
    You are given an array of non-overlapping intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

    Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

    Return intervals after the insertion.
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> store = new ArrayList<>();
        int i = 0;
        int length = intervals.length;
        while(i < length && intervals[i][1] < newInterval[0]){
            store.add(intervals[i]);
            i++;
        }
        while(i < length && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        store.add(newInterval);
        while(i < length) {
            store.add(intervals[i]);
            i++;
        }
        return store.toArray(new int[0][]);
    }
    /* 56. Merge Intervals
    Given an array of intervals where intervals[i] = [starti, endi],
    merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
     */
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals,  (int[] o1, int[] o2) -> o1[0] - o2[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i = 1; i< intervals.length; i++){
            if(intervals[i][0]<= end){
                start = Math.min(start, intervals[i][0]);
                end = Math.max(end, intervals[i][1]);
            }else{
                ans.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        ans.add(new int[]{start, end});
        return ans.toArray(new int[0][]);
    }
    /* 435. Non-overlapping Intervals
    Given an array of  intervals where intervals[i] = [starti, endi],
    return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length <= 1){
            return 0;
        }
        int ans = 0;
        Arrays.sort(intervals,(int[] o1, int[] o2) -> o1[0] - o2[0]);
        int end = intervals[0][1];
        for(int i = 1; i< intervals.length; i++){
            if(intervals[i][0] < end){
                end = Math.min(intervals[i][1], end);
                ans++;
            } else{
                end = intervals[i][1];
            }
        }
        return ans;
    }
    /* 252. Meeting Rooms
    Given an array of meeting time intervals where intervals[i] = [starti, endi],
    determine if a person could attend all meetings.
     */
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length <= 0){
            return true;
        }
        Arrays.sort(intervals, (int[] o1, int[] o2) -> o1[0]- o2[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] < end){
                return false;
            }else{
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        return true;
    }
    /* 253. Meeting Rooms II
    Given an array of meeting time intervals where intervals[i] = [starti, endi],
    return the minimum number of conference rooms required.
     */
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (int[] o1, int[] o2) -> o1[0]-o2[0]);
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] o1,int[] o2){
                return o1[1]-o2[1];
            }
        });
        int ans = 1;
        heap.add(intervals[0]);
        for(int i =1; i< intervals.length; i++){
            int earliestEnd = heap.peek()[1];
            if(earliestEnd > intervals[i][0]){
                heap.add(intervals[i]);
                ans = Math.max(ans, heap.size());
            }else{
                heap.poll();
                heap.add(intervals[i]);
            }
        }
        return ans;
    }

}
