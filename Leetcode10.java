package leetcode;

public class Leetcode10 {
    public static boolean isMatch(String s, String p) {

        // step2:
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        // s == "", p == b*c*
        for (int j = 1; j < p.length() + 1; j++) {
            if (p.charAt(j - 1) == '*' && j > 1 && dp[0][j - 2]) {
                dp[0][j] = true;
            }
        }

        // step3:

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else if (p.charAt(j - 1) == '*') {    // abcc    abc*
                    if (p.charAt(j - 2) != s.charAt(i - 1) && p.charAt(j - 2) != '.') {
                        dp[i][j] = dp[i][j - 2];
                    } else if (p.charAt(j - 2) != s.charAt(i - 1) && p.charAt(j - 2) == '.') {   // ab .*     bacd b.*
                        dp[i][j] = dp[i][j - 2] || dp[i][j - 1] || dp[i - 1][j];
                    } else {     // 0 match || 1 match || multiple match
                        dp[i][j] = dp[i][j - 2] || dp[i][j - 1] || dp[i - 1][j];
                    }
                }
            }
        }


        // step4:
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        System.out.println(isMatch("ab", ".*"));
    }
}
