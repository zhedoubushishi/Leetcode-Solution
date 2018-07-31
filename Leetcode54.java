import java.util.ArrayList;
import java.util.List;

public class Leetcode54 {

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<>();

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        int direction = 0;

        while (top <= bottom && left <= right) {

            if (direction % 4 == 0) {
                for (int i = left; i <= right; i++) {
                    res.add(matrix[top][i]);
                }
                top++;
            }

            if (direction % 4 == 1) {
                for (int i = top; i <= bottom; i++) {
                    res.add(matrix[i][right]);
                }
                right--;
            }

            if (direction % 4 == 2) {
                for (int i = right; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (direction % 4 == 1) {
                for (int i = left; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }

        return res;
    }


}
