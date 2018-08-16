public class Leetcode29 {

    public static int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return dividend >=0 ? Integer.MAX_VALUE : -Integer.MAX_VALUE;
        }

        if (dividend == 0) {
            return 0;
        }

        // ?
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        Boolean isPositive = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);

        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);

        int res = 0;
        while (a >= b) {
            int shift = 0;
            while (a >= b << shift) {
                shift++;
            }
            shift--;
            a -= b << shift;
            res += 1 << shift;
        }


        return isPositive ? res : -res;
    }

    public static void main(String[] args) {
        System.out.println(divide(-2147483647,-1));
    }
}
