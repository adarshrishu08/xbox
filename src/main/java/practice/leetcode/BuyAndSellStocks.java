package practice.leetcode;

/*
        You are given an array prices where prices[i] is the price of a given stock on the ith day.

        You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

        Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.



        Example 1:

        Input: prices = [7,1,5,3,6,4]
        Output: 5
        Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
        Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
        Example 2:

        Input: prices = [7,6,4,3,1]
        Output: 0
        Explanation: In this case, no transactions are done and the max profit = 0.


        Constraints:

        1 <= prices.length <= 105
        0 <= prices[i] <= 104
*/


public class BuyAndSellStocks {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
    }

//    private int findMinimumDay(int[] prices){
//        int min = 0;
//        for(int i=1; i<prices.length; i++){
//            if(prices[i-1] < prices[i]){
//                min = i-1;
//            }
//        }
//        return min;
//    }
}









//[0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0 , 1, 1, 0, 1,1,0]
//k = 2  ... k = 3
//6          //9

//[ 0 , 4, 0,0,0,2,0,2,0, 0 ,1]
//[6, 6, 2, 4, 6, 6, 4, 5 ]
//
//[7, 9, 5, ]
//0                                            17
//[4, 1-4 ,   2, 8-9    , 2, 11-12    2, 15-16]
//






