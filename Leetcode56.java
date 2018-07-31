import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Leetcode56 {
    public class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
    }

    public List<Interval> merge(List<Interval> intervals) {

        List<Interval> res = new ArrayList<>();

        if (intervals == null || intervals.size() == 0) {
            return res;
        }

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        Interval last =  intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (last.end >= cur.start) {
                last.end = Math.max(cur.end, last.end);
            } else {
                res.add(last);
                last = cur;
            }
        }

        res.add(last);

        return res;
    }
}
