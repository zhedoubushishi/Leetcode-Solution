public class Leetcode91 {

    public static int numDecodings(String s) {
        if (s == null) {
            return 0;
        }

        if (s.length() <= 1) {
            return s.length();
        }

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < s.length() + 1; i++) {
            if ((s.charAt(i - 1) - '0') > 2) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("226"));
    }
}
