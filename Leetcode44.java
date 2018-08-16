public class Leetcode44 {
    public boolean isMatch(String s, String p) {

        // 这道题有好几种解法！记忆化数组，详见九章

        // dp[i][j]: string s with len i match string p with len j
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

        for (int i = 1; i < s.length() + 1; i++) {
            dp[i][0] = false;
        }

        dp[0][0] = true;

        for (int i = 0; i < s.length() + 1; i++) {
            for (int j = 1; j < p.length() + 1; j++) {

                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1];
                    if (i > 0) {
                        dp[i][j] |= dp[i - 1][j];
                    }
                } else {
                    if (i > 0 && (p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1))) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }

        return dp[s.length()][p.length()];
    }
}
