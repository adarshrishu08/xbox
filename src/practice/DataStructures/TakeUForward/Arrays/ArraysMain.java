package practice.DataStructures.TakeUForward.Arrays;

public class ArraysMain {


    public static void main(String[] args) {
        ArraysMain am = new ArraysMain();
        int[] prices = {2,4,1};
        System.out.println("Max Profit : " + am.maxProfit(prices));
    }

    /**
     * Problem Statement: You are given an array of prices where prices[i] is the price of a given stock on an
     * ith day.
     *
     * You want to maximize your profit by choosing a single day to buy one stock and choosing a
     * different day in the future to sell that stock. Return the maximum profit you can achieve from this
     * transaction. If you cannot achieve any profit, return 0.
     */

    public int maxProfit(int[] prices) {
        Integer min=prices[0];
        int interval = 0;
        for(int i=0; i<prices.length; i++) {
            if(prices[i] < min) {
                min = prices[i];
            }

            int newInterval = prices[i] - min;
            if(newInterval > interval) {
                interval = newInterval;
            }

        }

        return interval;
    }
}
