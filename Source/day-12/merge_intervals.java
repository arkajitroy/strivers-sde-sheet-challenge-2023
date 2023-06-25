import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Interval {
    int start, finish;

    Interval(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }
}

class Solution {
    public static List<Interval> mergeIntervals(Interval[] intervals) {
        Arrays.sort(intervals, (a, b) -> a.start - b.start);

        List<Interval> mergedIntervals = new ArrayList<>();

        int start = intervals[0].start;
        int end = intervals[0].finish;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start <= end) {
                end = Math.max(end, intervals[i].finish);
            } else {
                mergedIntervals.add(new Interval(start, end));
                start = intervals[i].start;
                end = intervals[i].finish;
            }
        }

        mergedIntervals.add(new Interval(start, end));

        return mergedIntervals;
    }

    public static void main(String[] args) {
        // Example usage
        Interval[] intervals = {
                new Interval(1, 3),
                new Interval(2, 6),
                new Interval(8, 10),
                new Interval(15, 18)
        };

        List<Interval> merged = mergeIntervals(intervals);

        for (Interval interval : merged) {
            System.out.println("[" + interval.start + ", " + interval.finish + "]");
        }
    }
}
