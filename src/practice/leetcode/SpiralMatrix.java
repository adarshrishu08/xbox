package practice.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                        {1,2,3,4},
                        {5,6,7,8},
                        {9,10,11,12},
                        {13,14,15,16}
                       };
        System.out.println(new SpiralMatrix().spiralMatrix(matrix));
        int[][] newMatrix = new SpiralMatrix().generateMatrix(3);
        Stream.of(newMatrix).flatMapToInt(IntStream::of).forEach(System.out::println);;

//      1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10
//      ## Transpose
//        {1,4,7},
//        {2,5,8},
//        {3,6,9}
//      ## Image
//        {7,4,1},
//        {8,5,2},
//        {9,6,3}

    }

    public List<Integer>  spiralMatrix(int[][] matrix){
        List<Integer> resultOfSpiralMatrix = new ArrayList<>();
        int up = 0, down = matrix.length-1, left = 0, right = matrix[0].length-1;
        int dir = 0;
        while(up <= down && left <= right){
            //Move Left To Right
            if(dir == 0){
                for(int i=left ; i<=right ; i++){
                    resultOfSpiralMatrix.add(matrix[up][i]);
                }
                up++;
            }
            //Move Top To Bottom
            if(dir == 1){
                for(int i=up ; i<=down ; i++){
                    resultOfSpiralMatrix.add(matrix[i][right]);
                }
                right--;
            }
            //Move Right To Left
            if(dir == 2){
                for(int i=right; i>=left; i--){
                    resultOfSpiralMatrix.add(matrix[down][i]);
                }
                down--;
            }
            //Move Bottom To Top
            if(dir == 3){
                for(int i=down; i>=up; i--){
                    resultOfSpiralMatrix.add(matrix[i][left]);
                }
                left++;
            }
            dir = (dir+1)%4;
        }
        return resultOfSpiralMatrix;
    }

    //LeetCode Spiral Matrix 2;
    public int[][] generateMatrix(int n) {
        int[][] newMatrix = new int[n][n];
        int up = 0, down = n-1, left = 0, right = n-1;
        int dir = 0;
        int counter = 1;

        while(up <= down && left <= right){
            //Move Left To Right
            if(dir == 0){
                for(int i=left ; i<=right ; i++){
                    newMatrix[up][i] = counter++;
                    //resultOfSpiralMatrix.add(matrix[up][i]);
                }
                up++;
            }
            //Move Top To Bottom
            if(dir == 1){
                for(int i=up ; i<=down ; i++){
                    newMatrix[i][right] = counter++;
                    //resultOfSpiralMatrix.add(matrix[i][right]);
                }
                right--;
            }
            //Move Right To Left
            if(dir == 2){
                for(int i=right; i>=left; i--){
                    newMatrix[down][i] = counter++;
                    //resultOfSpiralMatrix.add(matrix[down][i]);
                }
                down--;
            }
            //Move Bottom To Top
            if(dir == 3){
                for(int i=down; i>=up; i--){
                    newMatrix[i][left] = counter++;
                    //resultOfSpiralMatrix.add(matrix[i][left]);
                }
                left++;
            }
            dir = (dir+1)%4;
        }
        return newMatrix;
    }

}
