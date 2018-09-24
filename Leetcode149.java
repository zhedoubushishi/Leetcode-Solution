import java.util.HashMap;

// Definition for a point.
class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}

public class Leetcode149 {

    public int maxPoints(Point[] points) {

        if (points == null || points.length == 0) {
            return 0;
        }

        HashMap<String, Integer> map = new HashMap<>();
        int max = 1;

        for (int i = 0; i < points.length; i++) {
            map.clear();
            int dup = 0;

            for (int j = i + 1; j < points.length; j++) {
                if (points[j].x == points[i].x && points[j].y == points[i].y) {
                    dup++;
                    continue;
                }

                String slope;
                if (points[j].x == points[i].x) {     // 斜率为正无穷的情况
                    slope = "verticle";
                } else {
                    int dx = points[j].x - points[i].x;
                    int dy = points[j].y - points[i].y;
                    int gcd = gcd(dx, dy);
                    dx /= gcd;
                    dy /= gcd;
                    slope = dx + "/" + dy;
                }

                if (map.containsKey(slope)) {
                    map.put(slope, map.get(slope) + 1);
                } else {
                    map.put(slope, 2);
                }
            }

            for (int count : map.values()) {
                if (count + dup > max) {
                    max = count + dup;
                }
            }

            if (map.size() == 0) {   // 所有Point全部一样
                if (dup + 1 > max) {
                    max = dup + 1;
                }
            }
        }

        return max;
    }


    // 求最大公约数
    private int gcd(int m, int n) {
        return n == 0 ? m : gcd(n, m % n);
    }

}