import java.util.HashSet;

public class Leetcode37 {
    public static void solveSudoku(char[][] board) {
        solve(board, 1);
    }


    private static boolean solve(char[][] board, int k) {

        if (k == 10) {
            return false;
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    continue;
                }

                board[i][j] = (char) ('0' + k);   // '1'
                if (!isValid(board, i, j) || !solve(board, 1)) {
                    board[i][j] = '.';
                    return solve(board, k + 1);
                }

                return true;
            }
        }
        return true; // if board is full
    }

    private static boolean isValid(char[][] board, int m, int n) {
        // row
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < 9; i++) {
            if (board[m][i] == '.') {
                continue;
            }
            if (!set.contains(board[m][i])) {
                set.add(board[m][i]);
            } else {
                return false;
            }
        }

        // col
        set.clear();
        for (int j = 0; j < 9; j++) {
            if (board[j][n] == '.') {
                continue;
            }
            if (!set.contains(board[j][n])) {
                set.add(board[j][n]);
            } else {
                return false;
            }
        }

        // 3*3
        set.clear();
        int startCol = (n / 3) * 3;
        int startRow = (m / 3) * 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (!set.contains(board[i][j])) {
                    set.add(board[i][j]);
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] boarder = {{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        solveSudoku(boarder);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.println(boarder[i][j]);
            }
        }
    }
}
