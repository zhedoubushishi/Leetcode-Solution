public class Leetcode48 {
    public static void rotate(int[][] matrix) {

        int bound = matrix.length - 1;

        // 对角线对称部分交换
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                swap(matrix, i ,j, j, i);
            }
        }

        // 左右对称部分交换
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length / 2; j++) {
                swap(matrix, i ,j, i, bound - j);
            }
        }
    }

    private static void swap(int[][] matrix, int a1, int a2, int b1, int b2) {
        int tmp = matrix[a1][a2];
        matrix[a1][a2] = matrix[b1][b2];
        matrix[b1][b2] = tmp;
    }




    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println(matrix[i][j]);
            }
        }
        rotate(matrix);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println(matrix[i][j]);
            }
        }
    }
}
