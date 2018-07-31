public class Leetcode59 {

    public int[][] generateMatrix(int n) {

        int[][] res = new int[n][n];
        if (n <= 0) {
            return res;
        }

        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;

        int direction = 0, num = 1;

        while (left <= right && top <= bottom) {
            if (direction % 4 == 0) {
                for (int i = left; i <= right; i++) {
                    res[top][i] = num++;
                }
                top++;
            }

            if (direction % 4 == 1) {
                for (int i = top; i <= bottom; i++) {
                    res[i][right] = num++;
                }
                right--;
            }

            if (direction % 4 == 2) {
                for (int i = right; i >= left; i--) {
                    res[bottom][i] = num++;
                }
                bottom--;
            }

            if (direction % 4 == 3) {
                for (int i = bottom; i >= top; i--) {
                    res[i][left] = num++;
                }
                left++;
            }

            direction++;
        }
        return res;
    }
}
