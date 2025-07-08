package practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class RatInMaze {

    static int maze[][] = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 1}
    };
    static int[][] visitedArr = new int[maze.length][maze.length];
    public static void main(String[] args) {
        int row=0, col = 0;
        System.out.println(findPath(row, col, ""));
    }

    public static boolean isSafe(int row, int col){
        if(row >= 0 && col >= 0 && row < maze.length && col < maze.length && visitedArr[row][col] == 0){
            return true;
        }
        return false;
    }

    // D,L,U,R
    public static List<String> findPath(int row, int col, String way){
        if(!isSafe(row, col)){
            return new ArrayList<>(0);
        }
        if(row == maze.length-1 && col == maze.length-1){
            List<String> paths = new ArrayList<>();
            paths.add(way);
            return paths;
        }

        visitedArr[row][col] = 1;
        List<String> path = new ArrayList<>();

        path.addAll(findPath(row+1, col, "D"));
        path.addAll(findPath(row, col-1, "L"));
        path.addAll(findPath(row, col+1, "R"));
        path.addAll(findPath(row-1, col, "U"));

        List<String> result = addPath(way, path);
        visitedArr[row][col] = 0;
        return result;
    }

    public static List<String> addPath(String currentNode, List<String> previousPaths){
        List<String> currentPaths = new ArrayList<>();
        for(String p : previousPaths){
            currentPaths.add(currentNode);
        }
        return currentPaths;
    }
}
