package recursionPractise;

import java.util.Map;

public class Fibonacci {

    public static void main(String[] args) {
//        printChars("Adarsh");
//        int[] i = new int[6];
//        System.out.println(fibonacci(5, i));
        String str = "ABCDE";
        System.out.println(str.substring(6));
//        permutation("","ABCD");
    }

    private static void printChars(String str) {
        if(str.length() == 0) {
            return;
        }
        printChars(str.substring(1));
        System.out.println(str.charAt(0));
    }

    private static int fibonacci(int n, int[] dp){
        if(n  <= 1){
            return n;
        }
        if(dp[n] != 0){
            return dp[n];
        }
        dp[n] = fibonacci(n-1, dp)+fibonacci(n-2, dp);
        return dp[n];
    }

    private static void permutation(String sofar, String text){
        if(text.length() == 0){
            System.out.println(sofar);
            return ;
        }
        for(int i=0; i<text.length(); i++){
            permutation(sofar+text.charAt(i), text.substring(0,i)+text.substring(i+1));
        }
    }
}
