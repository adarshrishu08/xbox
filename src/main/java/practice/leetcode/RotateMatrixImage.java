package practice.leetcode;

public class RotateMatrixImage {
    public static void main(String[] args) {
        int[][] matrix =  {
                            {1,2,3},
                            {4,5,6},
                            {7,8,9}
                          };
        System.out.println("Original Matrix");
        displayMatrix(matrix);
        transposedMatrix(matrix);
        System.out.println("Transposed Matrix");
        displayMatrix(matrix);
        reversed(matrix);
        //Output: [[7,4,1],[8,5,2],[9,6,3]]
    }

    public static void transposedMatrix(int[][] matrix){
        int len = matrix.length;
        for(int i=0; i<len; i++){
            for(int j=i+1; j<len; j++){
                int temp = matrix[j][i];//2,3
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }

    public static void reversed(int[][] matrix){
        int len = matrix.length;
        for(int i=0; i<len; i++){
            int startPointer = 0;
            int endPointer = matrix.length-1;
            for(int j=0; j<len; j++) {
                int temp = matrix[i][startPointer];//2
                matrix[i][startPointer] = matrix[i][endPointer];//8
                matrix[i][endPointer] = temp;//2
                if (startPointer != endPointer) {
                    startPointer++;
                    endPointer--;
                } else {
                    break;
                }
            }
        }
        System.out.println("Reversed Matrix");
        displayMatrix(matrix);
    }

    public static void displayMatrix(int[][] matrix){
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
