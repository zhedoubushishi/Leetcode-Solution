public class Leetcode64 {

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        int sum = 0;

        for (int i = 0; i < m; i++) {
            dp[i][0] = sum + grid[i][0];
            sum += grid[i][0];
        }

        sum = 0;
        for (int j = 0; j < n; j++) {
            dp[0][j] = sum + grid[0][j];
            sum += grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][] {{1,3,1},{1,5,1},{4,2,1}}));
    }
}
