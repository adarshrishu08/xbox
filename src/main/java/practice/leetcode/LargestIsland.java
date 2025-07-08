package practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LargestIsland {

    static int[][] world = {
            {0, 1, 1, 0, 1, 1, 0},
            {1, 1, 0, 1, 1, 1, 1},
            {0, 1, 1, 0, 0, 1, 1},
            {1, 0, 1, 0, 1, 0, 1},
            {1, 1, 1, 0, 1, 1, 0},
            {0, 0, 0, 1, 1, 1, 0},
            {1, 1, 1, 0, 1, 0, 1},
    };

    public static void main(String[] args) {
        new LargestIsland().countLargestIsland();
    }

    public boolean isSafe(int row, int col) {
        if (row >= 0 && col >= 0 && row < world.length && col < world[0].length && world[row][col] == 1) {
            return true;
        }
        return false;
    }

    public void countLargestIsland() {
        List<Integer> islands = new ArrayList<>();
        for (int i = 0; i < world.length; i++) {
            for (int j = 0; j < world.length; j++) {
                if(world[i][j] == 1) {
                    islands.add(largestIsland(i, j));
                }
            }
        }
        System.out.println(islands);
    }

    public int largestIsland(int row, int col) {
        if (!isSafe(row, col)) {
            return 0;
        }
        world[row][col] = 2;
        return 1 + largestIsland(row + 1, col) +
                largestIsland(row, col - 1) +
                largestIsland(row - 1, col) +
                largestIsland(row, col + 1);
    }
}
