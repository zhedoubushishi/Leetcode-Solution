import java.util.ArrayList;
import java.util.List;

public class Leetcode51 {
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        helper(res, new boolean[n][n], 0, n);
        return res;
    }

    private static void helper(List<List<String>> res,
                        boolean[][] hasQueen,
                        int line,
                        int n) {

        if (line == n) {
            res.add(convert(hasQueen));
            return;
        }

        for (int i = 0; i < n; i++) {
            hasQueen[line][i] = true;

            if (!isValid(hasQueen, line, i)) {
                hasQueen[line][i] = false;
                continue;
            }

            helper(res, hasQueen, line + 1, n);
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



    private static List<String> convert(boolean[][] hasQueen) {

        List<String> res = new ArrayList<>();

        for (int i = 0; i < hasQueen.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < hasQueen[0].length; j++) {
                if (hasQueen[i][j]) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            res.add(sb.toString());
        }

        return res;
    }




    public static void main(String[] args) {
        List<List<String>> res = solveNQueens(4);
        for (int i = 0; i < 4; i++) {
            System.out.println(res.get(1).get(i));
        }
    }
}
