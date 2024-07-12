package practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public static void main(String[] args) {
        int[][] array = {{1},{1,1},{1,2,1},{1,3,3,1},{1,4,6,4,1}};
        System.out.println(array.length);
        int n = 5;
        List<List<Integer>> matrix = new ArrayList<>();

        int target = 3;
        int row = 0;
        int column =  array.length-1;
        for(int i=0; i<array.length; i++){

            while (array[row][column] != target){
                if(array[row][column]<target){
                    row--;
                } else if(array[row][column]<target){
                    column++;
                }
            }

        }

//        for(int i=1; i<=n; i++){
//            int predecessor = 0;
//            int successor = 0;
//            int count = 1;
//            List<Integer> list = new ArrayList<>();
//            for(int j=1; j<=i; j++){
//               if(matrix.get(j-1).size()==0) {
//                   list.add(count);
//                   predecessor = list.get(j-1);
//                   successor = list.get(j-1);
//               } else {
//                    predecessor =+ predecessor;
//                    successor =+ successor;
////                    list.add()
//               }
//            }
//            count++;
//            matrix.add(list);
//        }

        System.out.println(matrix);
    }
}
