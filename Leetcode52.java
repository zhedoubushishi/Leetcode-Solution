public class Leetcode52 {

    private static int sum;

    public int totalNQueens(int n) {
        sum = 0;

        helper(new boolean[n][n], 0, n);
        return sum;
    }

    private void helper(boolean[][] hasQueen,
                        int line,
                        int n) {
        if (line == n) {
            sum++;
            return;
        }

        for (int i = 0; i < n; i++) {
            hasQueen[line][i] = true;
            if (!isValid(hasQueen, line, i)) {
                hasQueen[line][i] = false;
                continue;
            }

            helper(hasQueen, line + 1, n);
            hasQueen[line][i] = false;
        }

    }

    private static boolean isValid(boolean[][] hasQueen, int line, int i) {

        int n = hasQueen.length;
        // col
        for (int k = 0; k < line; k++) {
            if (hasQueen[k][i]) {
                return false;
            }
        }

        //
        int x = line - 1;
        int y = i - 1;
        while (y >= 0 && x >= 0) {
            if (hasQueen[x][y]) {
                return false;
            }
            y--;
            x--;
        }

        x = line - 1;
        y = i + 1;

        while (x >= 0 && y < n) {
            if (hasQueen[x][y]) {
                return false;
            }
            y++;
            x--;
        }

        return true;
    }
}
