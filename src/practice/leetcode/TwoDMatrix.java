package practice.leetcode;

public class TwoDMatrix {

    public static void main(String[] args) {

        int[][] matrix = {
                            {1,  3,  5,  7},
                            {10, 11, 16, 20},
                            {23, 30, 34, 60}
                        };
        int target = 35;
        System.out.println(searchInTwoDMatrix(matrix, target));
    }

    public static boolean searchInTwoDMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;
        boolean isPresent = false;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                isPresent = true;
                System.out.println(row);
                System.out.println(col);
                return isPresent;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return isPresent;
    }
}
