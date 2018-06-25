package example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Created by sharanya.p on 1/15/2018.
 */
public class MergeOverlapIntervals {


    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<>();
        Interval i1 = new Interval(1, 3);
        Interval i2 = new Interval(2, 6);
        Interval i3 = new Interval(8, 10);
        Interval i4 = new Interval(15, 18);
        intervals.add(i1);
        intervals.add(i2);
        intervals.add(i3);
        intervals.add(i4);
        MergeOverlapIntervals mergeOverlapIntervals = new MergeOverlapIntervals();
        mergeOverlapIntervals.merge(intervals);
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> res = new ArrayList<>();
        LinkedList<Interval> merged = new LinkedList<>();
        Collections.sort(intervals, new IntervalComparator());
        for (Interval interval : intervals) {
            if (merged.isEmpty() || merged.getLast().end < interval.start) {
                merged.add(interval);
            } else {
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }
        for (Interval i :
                merged) {
            res.add(i);
        }
        Collections.sort(res, new IntervalComparator());
        return res;
    }

    private class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
        }
    }
}

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

