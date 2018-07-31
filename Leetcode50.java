public class Leetcode50 {

    public double myPow(double x, int n) {

        if (n < 0) {
            return 1 / helper(x, n);
        }

        return helper(x, n);
    }

    private double helper(double x, int n) {
        if (n == 0) {
            return 1;
        }

        double res = helper(x, n / 2);

        if (n % 2 != 0) {
            return res * res * x;
        }

        return res * res;
    }

    public static void main(String[] args) {
        int a = -2147483647;
        int b = Integer.MIN_VALUE;
        int c = -b;
    }
}
