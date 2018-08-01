public class Leetcode69 {
    public static int mySqrt(int x) {
        int start = 1;
        int end = x;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (mid * mid <= x) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (end * end <= x) {
            return (int) end;
        }

        return (int) start;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(Integer.MAX_VALUE));
    }
}
