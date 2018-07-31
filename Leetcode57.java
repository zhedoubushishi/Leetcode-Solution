import java.util.ArrayList;
import java.util.List;

public class Leetcode57 {
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        List<Interval> res = new ArrayList<>();
        int insertIndex = 0;

        for (int i = 0; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);

            if (cur.end < newInterval.start) {
                res.add(cur);
                insertIndex++;
            } else if (newInterval.end < cur.start) {
                res.add(cur);
            } else if (cur.end >= newInterval.start || cur.start <= newInterval.end) {
                newInterval.start = Math.min(cur.start, newInterval.start);
                newInterval.end = Math.max(cur.end, newInterval.end);
            }
        }

        res.add(insertIndex, newInterval);

        return res;
    }
}
