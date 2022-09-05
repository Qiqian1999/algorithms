import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

}
