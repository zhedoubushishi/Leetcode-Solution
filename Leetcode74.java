public class Leetcode74 {

    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length - 1;
        int n = matrix[0].length - 1;

        int start = 0;
        int end = m;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target <= matrix[mid][0]) {
                end = mid;
            } else {
                start = mid;
            }
        }

        int row;
        if (target >= matrix[end][0]) {
            row = end;
        } else {
            row = start;
        }

        start = 0;
        end = n;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target <= matrix[row][mid]) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (target == matrix[row][start] || target == matrix[row][end]) {
            return true;
        }

        return false;
    }
}
