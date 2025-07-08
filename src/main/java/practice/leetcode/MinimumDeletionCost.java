package practice.leetcode;

public class MinimumDeletionCost {
    public static void main(String[] args) {
//        String s = "abaac";
//        int[] cost = {1,2,3,4,5};

        String s = "aabbcc";
        int[] cost = {1, 2, 1, 2, 1, 2};
        System.out.println(new MinimumDeletionCost().minCost(s, cost));
    }


    public int minCost(String s, int[] cost) {
        int totalCost = 0;
        char prevLetter = s.charAt(0);
        int maxCost = cost[0];
        int currentTotalCost = cost[0];
        for (int i = 1; i < s.length(); i++) {
            char currentIteratingLetter = s.charAt(i);
            int currentIteratingCost = cost[i];
            if (currentIteratingLetter == prevLetter) {
                maxCost = Math.max(maxCost, currentIteratingCost);
                currentTotalCost += currentIteratingCost;
            } else {
                totalCost += currentTotalCost - maxCost;
                prevLetter = currentIteratingLetter;
                maxCost = currentIteratingCost;
                currentTotalCost = currentIteratingCost;
            }
        }
        totalCost += currentTotalCost - maxCost;
        return totalCost;
    }
}
