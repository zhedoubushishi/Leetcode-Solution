import java.util.Arrays;

public class Leetcode36 {

    public static boolean isValidSudoku(char[][] board) {
        boolean visited[] = new boolean[10];

        // row
        for (int i = 0; i < 9; i++) {
            Arrays.fill(visited, false);
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (!visited[board[i][j] - '0']) {
                    visited[board[i][j] - '0'] = true;
                } else {
                    return false;
                }
            }
        }

        // col
        for (int j = 0; j < 9; j++) {
            Arrays.fill(visited, false);
            for (int i = 0; i < 9; i++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (!visited[board[i][j] - '0']) {
                    visited[board[i][j] - '0'] = true;
                } else {
                    return false;
                }
            }
        }

        // 3*3
        for (int i = 0; i < 9; i = i + 3) {
            for (int j = 0; j < 9; j = j + 3) {

                Arrays.fill(visited, false);
                for (int m = i; m < i + 3; m++) {
                    for (int n = j; n < j + 3; n++) {
                        if (board[i][j] == '.') {
                            continue;
                        }
                        if (!visited[board[m][n] - '0']) {
                            visited[board[m][n] - '0'] = true;
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // char[][] boarder = new char[9][9];
        char[][] boarder = {{'5','3','.','.','7','.','.','.','.'},
                            {'6','.','.','1','9','5','.','.','.'},
                            {'.','9','8','.','.','.','.','6','.'},
                            {'8','.','.','.','6','.','.','.','3'},
                            {'4','.','.','8','.','3','.','.','1'},
                            {'7','.','.','.','2','.','.','.','6'},
                            {'.','6','.','.','.','.','2','8','.'},
                            {'.','.','.','4','1','9','.','.','5'},
                            {'.','.','.','.','8','.','.','7','9'}};

        System.out.println(isValidSudoku(boarder));
    }
}